package springMVC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import springMVC.entity.FeedbackEntity;
@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Integer>{
	@Query("select f from FeedbackEntity f where f.product.productId =:productId")
	List<FeedbackEntity> findByProductId(@Param("productId") int productId);
	FeedbackEntity findByFeedbackId( int feedbackId);
}
