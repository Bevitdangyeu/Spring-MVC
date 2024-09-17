package springMVC.service.Implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springMVC.DTO.BillDTO;
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
		// tính toán tổng bill 
		float tong=0;
		int tongSl=0;
		List<Float> tongTien=new ArrayList<Float>();
		for (int i=0;i<bill.getPrince().size();i++) {
			tongTien.add(bill.getPrince().get(i)*bill.getQuantity().get(i));
		}
		bill.setTotal(tongTien);
		for(int i=0;i<bill.getTotal().size();i++) {
			tong+=bill.getTotal().get(i);
		}
		for(int i=0;i<bill.getQuantity().size();i++) {
			tongSl+=bill.getQuantity().get(i);
		}
		// lấy employee từ cơ sở dữ liệu
		EmployeeEntity employee=new EmployeeEntity();
		employee=employeeResponsitory.findByEmployeeId(bill.getEmployeeID());
		// tìm khách hàng từ csdl, nếu đã có thì lấy KH đó còn nếu chưa có thì tạo mới 
		customerEntity customer=customerResponsitory.findByCustomerName(bill.getCustomerName());
		if(customer==null) {
			customer=new customerEntity();
			customer.setCustomerName(bill.getCustomerName());
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
			List<DetailBillEntity> list=new ArrayList<DetailBillEntity>();
			for(int i=0;i<bill.getProduct().size();i++) {
				DetailBillEntity detailBill=new DetailBillEntity();
				ProductEntity product=productResponsitory.findOneByName(bill.getProduct().get(i));
				detailBill.setProduct(product);
				detailBill.setBill(billEntity);
				detailBill.setPrice(bill.getPrince().get(i));
				detailBill.setQuantity(bill.getQuantity().get(i));
				detailBill.setTotal(bill.getTotal().get(i));
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
			for(int i=0;i<bill.getProduct().size();i++) {
				if(i<billEntity.getList().size()) {
					DetailBillEntity detailBill= billEntity.getList().get(i);
					ProductEntity product=productResponsitory.findOneByName(bill.getProduct().get(i));
					detailBill.setProduct(product);
					detailBill.setBill(billEntity);
					detailBill.setPrice(bill.getPrince().get(i));
					detailBill.setQuantity(bill.getQuantity().get(i));
					detailBill.setTotal(bill.getTotal().get(i));
				}else {
					DetailBillEntity detailBill=new DetailBillEntity();
					ProductEntity product=productResponsitory.findOneByName(bill.getProduct().get(i));
					detailBill.setProduct(product);
					detailBill.setBill(billEntity);
					detailBill.setPrice(bill.getPrince().get(i));
					detailBill.setQuantity(bill.getQuantity().get(i));
					detailBill.setTotal(bill.getTotal().get(i));
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
			for(int j=0;j<billEntity.get(i).getList().size();j++) {
				DetailBillEntity detail =billEntity.get(i).getList().get(j);
				bill.addProduct(detail.getProduct().getName());
				bill.addPrice(detail.getPrice());
				bill.addQuantity(detail.getQuantity());
				bill.addTotal(detail.getTotal());
			}
			bill.setTotalPrice(billEntity.get(i).getTotalPrice());
			bill.setTotalQuantity(billEntity.get(i).getTotalQuantity());
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
		for(int j=0;j<billEntity.getList().size();j++) {
			DetailBillEntity detail =billEntity.getList().get(j);
			bill.addProduct(detail.getProduct().getName());
			bill.addPrice(detail.getPrice());
			bill.addQuantity(detail.getQuantity());
			bill.addTotal(detail.getTotal());
		}
		bill.setTotalPrice(billEntity.getTotalPrice());
		bill.setTotalQuantity(billEntity.getTotalQuantity());
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
	
}
