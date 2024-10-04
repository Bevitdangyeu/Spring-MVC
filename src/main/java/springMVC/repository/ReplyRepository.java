package springMVC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import springMVC.entity.ReplyEntity;
@Repository
public interface ReplyRepository extends CrudRepository<ReplyEntity, Integer> {
	@Query("select r from ReplyEntity r where r.feedback.feedbackId =:feedbackId")
	List<ReplyEntity> findByFeedbackId(@Param("feedbackId") int feedbackId);
	ReplyEntity findByReplyId(int replyId);
}
