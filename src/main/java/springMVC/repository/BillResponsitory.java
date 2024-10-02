package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import springMVC.entity.BillEntity;
@Repository
public interface BillResponsitory extends JpaRepository<BillEntity, Integer>{
	BillEntity findByBillId(int billId);
	@Query("select b from BillEntity b where b.status like %:status%")
	List<BillEntity> findApproveOrder(@Param("status") String status);
	
	  @Query("select b from BillEntity b where b.status like %:status% and b.customer.customerId =:customerId"
	  ) List<BillEntity> findPurchaseHistory(@Param("status") String status,@Param("customerId") int customerId );
	 
}
