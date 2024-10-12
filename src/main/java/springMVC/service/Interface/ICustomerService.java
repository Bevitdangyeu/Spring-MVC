package springMVC.service.Interface;
import java.util.List;

import springMVC.DTO.CustomerDTO;
public interface ICustomerService {
	List<CustomerDTO> findAll();
	CustomerDTO findByCustomerId( int id);
}
