package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.EmployeeEntity;
@Repository
public interface EmployeeResponsitory extends JpaRepository<EmployeeEntity, Integer>{
	EmployeeEntity findByEmployeeId(int employeeId);
}
