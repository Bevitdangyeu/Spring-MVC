package springMVC.service.Interface;

import java.util.List;

import org.springframework.data.domain.Pageable;

import springMVC.DTO.BillDTO;

public interface IBillService {
	BillDTO addBill(BillDTO bill);
	List<BillDTO> findAll(Pageable page);
	BillDTO findById(int id);
	int delete(BillDTO bill);
	List<BillDTO> findApproveOrder(String status);
	void updateStatus(BillDTO bill);
	List<BillDTO> PurchaseHistory(int customerId,String status);
}
