package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.CustomerDTO;
import springMVC.entity.customerEntity;
import springMVC.repository.CustomerResponsitory;
import springMVC.service.Interface.ICustomerService;
@Service
public class CustomerService implements ICustomerService {
	@Autowired CustomerResponsitory customerRepository;
	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> listCustomer=new ArrayList<CustomerDTO>();
		List<customerEntity> listCustomerEntity=customerRepository.findAll();
		// chuyển từ entity sang dto
		for(int i=0;i<listCustomerEntity.size();i++) {
			customerEntity entity=listCustomerEntity.get(i);
			CustomerDTO customer=new CustomerDTO();
			customer.setCustomerId(entity.getCustomerId());
			customer.setCustomerName(entity.getCustomerName());
			customer.setAddress(entity.getAddress());
			customer.setImg(entity.getImg());
			customer.setPhoneNumber(entity.getPhoneNumber());
			customer.setUserId(entity.getUserId().getId());
			listCustomer.add(customer);
		}
		return listCustomer;
	}
	@Transactional
	@Override
	public CustomerDTO findByCustomerId(int id) {
		customerEntity customerEntity=customerRepository.findByCustomerId(id);
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setCustomerId(customerEntity.getCustomerId());
		customerDTO.setAddress(customerEntity.getAddress());
		customerDTO.setCustomerName(customerEntity.getCustomerName());
		customerDTO.setImg(customerEntity.getImg());
		customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
		customerDTO.setUserId(customerEntity.getUserId().getId());
		return customerDTO;
	}
	
	
}
