package springMVC.service.Implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springMVC.DTO.BillDTO;
import springMVC.DTO.CheckoutDTO;
import springMVC.entity.BillEntity;
import springMVC.entity.DetailBillEntity;
import springMVC.entity.EmployeeEntity;
import springMVC.entity.ProductEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.BillResponsitory;
import springMVC.repository.CustomerResponsitory;
import springMVC.repository.EmployeeResponsitory;
import springMVC.repository.ProductRespository;
import springMVC.service.Interface.IBillService;
@Service
public class BillService implements IBillService {
	@Autowired
	CustomerResponsitory customerResponsitory;
	@Autowired
	EmployeeResponsitory employeeResponsitory;
	@Autowired
	ProductRespository productResponsitory;
	@Autowired
	BillResponsitory billResponsitory;
	@Transactional
	@Override
	public BillDTO addBill(BillDTO bill) {
		// set trạng thái
		if(bill.getEmployeeID()!=1) {
			bill.setStatus("Hoàn Thành");
		}
		// tính toán tổng bill 
		float tong=0;
		int tongSl=0;
		// tính tổng tiền của hóa đơn
		for(int i=0;i<bill.getItems().size();i++) {
			tong+=bill.getItems().get(i).getTotal();
		}
		bill.setTotalPrice(tong);
		// tính tông số lượng sản phẩm
		for(int i=0;i<bill.getItems().size();i++) {
			tongSl+=bill.getItems().get(i).getQuantity();
		}
		bill.setTotalQuantity(tongSl);
		// lấy employee từ cơ sở dữ liệu
		EmployeeEntity employee=new EmployeeEntity();
		employee=employeeResponsitory.findByEmployeeId(bill.getEmployeeID());
		// tìm khách hàng từ csdl, nếu đã có thì lấy KH đó còn nếu chưa có thì tạo mới 
		customerEntity customer=customerResponsitory.findByCustomerName(bill.getCustomerName());
		if(customer==null) {
			customer=new customerEntity();
			customer.setCustomerName(bill.getCustomerName());
			customer.setPhoneNumber(bill.getPhone());
			customer.setAddress(bill.getAddress());
			customer.setStatus(1);
		
		}
		if(bill.getBillId()==0) { // thêm mới 
			// từ bill DTO chuyển sang Entity
			// chuyển sang bill
			BillEntity billEntity=new BillEntity();
			LocalDateTime currentDateTime = LocalDateTime.now();
			// chuyển đổi từ bill DTO sang BillEntity
			billEntity.setCustomer(customer);
			billEntity.setDate(currentDateTime);
			billEntity.setEmployee(employee);
			billEntity.setTotalPrice(tong);
			billEntity.setTotalQuantity(tongSl);
			billEntity.setStatus(bill.getStatus());
			List<DetailBillEntity> list=new ArrayList<DetailBillEntity>();
			for(int i=0;i<bill.getItems().size();i++) {
				DetailBillEntity detailBill=new DetailBillEntity();
				ProductEntity product=productResponsitory.findOneByName(bill.getItems().get(i).getProduct());
				detailBill.setProduct(product);
				detailBill.setBill(billEntity);
				detailBill.setPrice(bill.getItems().get(i).getPrince());
				detailBill.setQuantity(bill.getItems().get(i).getQuantity());
				detailBill.setTotal(bill.getItems().get(i).getTotal());
				detailBill.setColor(bill.getItems().get(i).getColor());
				detailBill.setSize(bill.getItems().get(i).getSize());
				list.add(detailBill);
			}
			billEntity.setList(list);
			billResponsitory.save(billEntity);
		}
		else if(bill.getBillId()!=0) {// chỉnh sửa
			// lấy bill đó lên từ cơ sở dữ liệu
			BillEntity billEntity=billResponsitory.findByBillId(bill.getBillId());
			billEntity.setCustomer(customer);
			billEntity.setEmployee(employee);
			billEntity.setTotalPrice(tong);
			billEntity.setTotalQuantity(tongSl);
			List<DetailBillEntity> list=billEntity.getList();
			for(int i=0;i<bill.getItems().size();i++) {
				if(i<billEntity.getList().size()) {
					/// lấy bill detail cũ và sau đó set lại giá trị mới
					DetailBillEntity detailBill= billEntity.getList().get(i);
					ProductEntity product=productResponsitory.findOneByName(bill.getItems().get(i).getProduct());
					detailBill.setProduct(product);
					detailBill.setBill(billEntity);
					detailBill.setPrice(bill.getItems().get(i).getPrince());
					detailBill.setQuantity(bill.getItems().get(i).getQuantity());
					detailBill.setTotal(bill.getItems().get(i).getTotal());
					detailBill.setColor(bill.getItems().get(i).getColor());
					detailBill.setSize(bill.getItems().get(i).getSize());
				}
				// nếu như có một sản phẩm mới được thêm vào thì size nó sẽ lớn hơn=> thêm mới vào 
				else {
					// tạo mới một billdetail mới và gán cho nó giá trị mới 
					DetailBillEntity detailBill=new DetailBillEntity();
					ProductEntity product=productResponsitory.findOneByName(bill.getItems().get(i).getProduct());
					detailBill.setProduct(product);
					detailBill.setBill(billEntity);
					detailBill.setPrice(bill.getItems().get(i).getPrince());
					detailBill.setQuantity(bill.getItems().get(i).getQuantity());
					detailBill.setTotal(bill.getItems().get(i).getTotal());
					detailBill.setColor(bill.getItems().get(i).getColor());
					detailBill.setSize(bill.getItems().get(i).getSize());
					list.add(detailBill);
				}
				
			}
			billEntity.setList(list);
			billResponsitory.save(billEntity);
		}
		
		return null;
	}
	@Transactional
	@Override
	public List<BillDTO> findAll(Pageable page) {
		List<BillDTO> list=new ArrayList<BillDTO>();
		List<BillEntity> billEntity= (List<BillEntity>) billResponsitory.findAll(page).getContent();
		// chuyển từ Entity sang DTO
		for( int i=0;i<billEntity.size();i++) {
			BillDTO bill=new BillDTO();
			bill.setBillId(billEntity.get(i).getBillId());
			bill.setCustomerName(billEntity.get(i).getCustomer().getCustomerName());
			bill.setDate(billEntity.get(i).getDate());
			bill.setEmployeeID(billEntity.get(i).getEmployee().getEmployeeId());
			bill.setEmployeeID(billEntity.get(i).getEmployee().getEmployeeId());
			bill.setStatus(billEntity.get(i).getStatus());
			List<CheckoutDTO> listCheckout=new ArrayList<CheckoutDTO>();
			for(int j=0;j<billEntity.get(i).getList().size();j++) {
				DetailBillEntity detail =billEntity.get(i).getList().get(j);
				CheckoutDTO checkout=new CheckoutDTO();
				checkout.setFeedbacked(detail.getFeedbacked());
				checkout.setBillDetailId(detail.getDetailBillId());
				checkout.setProductId(detail.getProduct().getProductId());
				checkout.setProduct(detail.getProduct().getName());
				checkout.setPrince(detail.getPrice());
				checkout.setQuantity(detail.getQuantity());
				checkout.setTotal(detail.getTotal());
				listCheckout.add(checkout);
			}
			bill.setItems(listCheckout);
			list.add(bill);
		}
		return list;
	}
	@Transactional
	@Override
	public BillDTO findById(int id) {
		BillEntity billEntity=billResponsitory.findByBillId(id);
		// chuyển từ entity sang model
		BillDTO bill=new BillDTO();
		bill.setBillId(billEntity.getBillId());
		bill.setCustomerName(billEntity.getCustomer().getCustomerName());
		bill.setDate(billEntity.getDate());
		bill.setEmployeeID(billEntity.getEmployee().getEmployeeId());
		bill.setEmployeeID(billEntity.getEmployee().getEmployeeId());
		bill.setStatus(billEntity.getStatus());
		List<CheckoutDTO> listCheckout=new ArrayList<CheckoutDTO>();
		for(int j=0;j<billEntity.getList().size();j++) {
			DetailBillEntity detail =billEntity.getList().get(j);
			CheckoutDTO checkout=new CheckoutDTO();
			checkout.setFeedbacked(detail.getFeedbacked());
			checkout.setBillDetailId(detail.getDetailBillId());
			checkout.setProductId(detail.getProduct().getProductId());
			checkout.setProduct(detail.getProduct().getName());
			checkout.setPrince(detail.getPrice());
			checkout.setQuantity(detail.getQuantity());
			checkout.setTotal(detail.getTotal());
			checkout.setSize(detail.getSize());
			checkout.setColor(detail.getColor());
			checkout.setImage(detail.getProduct().getImage());
			listCheckout.add(checkout);
			
		}
		bill.setItems(listCheckout);
		return bill;
	}
	@Transactional
	@Override
	public int delete(BillDTO bill) {
		ProductEntity product =productResponsitory.findOneByName(bill.getProductName());
		BillEntity billEntity=billResponsitory.findByBillId(bill.getBillId());
		for(int i=0;i<billEntity.getList().size();i++) {
			DetailBillEntity detail=billEntity.getList().get(i);
			if(detail.getProduct().getProductId()==product.getProductId()) {
				billEntity.getList().remove(i);
			}
		}
		// cập nhật lại tổng tiền và số lượng
		float tong=0;
		int sl=0;
		for( int i=0;i<billEntity.getList().size();i++) {
			tong+=billEntity.getList().get(i).getTotal();
		}
		for( int i=0;i<billEntity.getList().size();i++) {
			sl+=billEntity.getList().get(i).getQuantity();
		}
		billEntity.setTotalPrice(tong);
		billEntity.setTotalQuantity(sl);
		billResponsitory.save(billEntity);
		return billEntity.getBillId();
	}
	@Transactional
	@Override
	public List<BillDTO> findApproveOrder(String status) {
		List<BillEntity> billEntity=billResponsitory.findApproveOrder(status);
		List<BillDTO> list=new ArrayList<BillDTO>();
		for( int i=0;i<billEntity.size();i++) {
			BillDTO bill=new BillDTO();
			bill.setBillId(billEntity.get(i).getBillId());
			bill.setCustomerName(billEntity.get(i).getCustomer().getCustomerName());
			bill.setDate(billEntity.get(i).getDate());
			bill.setEmployeeID(billEntity.get(i).getEmployee().getEmployeeId());
			bill.setEmployeeID(billEntity.get(i).getEmployee().getEmployeeId());
			bill.setStatus(billEntity.get(i).getStatus());
			List<CheckoutDTO> listCheckout=new ArrayList<CheckoutDTO>();
			for(int j=0;j<billEntity.get(i).getList().size();j++) {
				DetailBillEntity detail =billEntity.get(i).getList().get(j);
				CheckoutDTO checkout=new CheckoutDTO();
				checkout.setProduct(detail.getProduct().getName());
				checkout.setPrince(detail.getPrice());
				checkout.setQuantity(detail.getQuantity());
				checkout.setTotal(detail.getTotal());
				checkout.setImage(detail.getProduct().getImage());
				listCheckout.add(checkout);
			}
			bill.setItems(listCheckout);
			list.add(bill);
		}
		return list;
	}
	@Override
	public void updateStatus(BillDTO bill) {
		BillEntity billEntity=billResponsitory.findByBillId(bill.getBillId());
		billEntity.setStatus(bill.getStatus());
		billResponsitory.save(billEntity);
	}
	@Transactional
	  @Override 
	  public List<BillDTO> PurchaseHistory(int customerId, String status) {
			// chuyển đổi tìm userId thông qua mã khách hàng
		  List<BillEntity> billEntities = billResponsitory.findPurchaseHistory(status, customerId);
		    List<BillDTO> billDTOs = new ArrayList<>();

		    for (BillEntity billEntity : billEntities) {
		        BillDTO billDTO = new BillDTO();
		        billDTO.setBillId(billEntity.getBillId());
		        billDTO.setCustomerName(billEntity.getCustomer().getCustomerName());
		        billDTO.setDate(billEntity.getDate());
		        billDTO.setEmployeeID(billEntity.getEmployee().getEmployeeId());
		        billDTO.setStatus(billEntity.getStatus());

		        // Chuyển đổi chi tiết hóa đơn
		        List<CheckoutDTO> checkoutDTOs = new ArrayList<>();
		        for (DetailBillEntity detail : billEntity.getList()) {
		            CheckoutDTO checkoutDTO = new CheckoutDTO();
		            checkoutDTO.setFeedbacked(detail.getFeedbacked());
		            checkoutDTO.setBillDetailId(detail.getDetailBillId());
		            checkoutDTO.setProductId(detail.getProduct().getProductId());
		            checkoutDTO.setProduct(detail.getProduct().getName());
		            checkoutDTO.setPrince(detail.getPrice());
		            checkoutDTO.setQuantity(detail.getQuantity());
		            checkoutDTO.setTotal(detail.getTotal());
		            checkoutDTO.setImage(detail.getProduct().getImage());

		            checkoutDTOs.add(checkoutDTO);
		        }

		        billDTO.setItems(checkoutDTOs);
		        billDTOs.add(billDTO);
		    }

		    return billDTOs;
	  }
	 
	
}
