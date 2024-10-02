package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springMVC.entity.customerEntity;
@Repository
public interface CustomerResponsitory extends JpaRepository<customerEntity, Integer> {
	customerEntity findByCustomerName(String customerName);
	@Query("select c from customerEntity c where c.userId.userId=:userId ")
	customerEntity findByUserId(@Param(value="userId") int userId);
}
