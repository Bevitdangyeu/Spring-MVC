package springMVC.service.Interface;

import java.util.List;

import org.springframework.data.domain.Pageable;

import springMVC.DTO.BillDTO;

public interface IBillService {
	BillDTO addBill(BillDTO bill);
	List<BillDTO> findAll(Pageable page);
	BillDTO findById(int id);
	int delete(BillDTO bill);
}
