package springMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.DetailBillEntity;
@Repository
public interface BillDetailRepository extends CrudRepository<DetailBillEntity, Integer> {
	DetailBillEntity findByDetailBillId( int detailBillId);
}
