package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.customerEntity;
@Repository
public interface CustomerResponsitory extends JpaRepository<customerEntity, Integer> {
	customerEntity findByCustomerName(String customerName);
}
