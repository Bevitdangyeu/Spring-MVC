package springMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springMVC.entity.ConversationParticipantEntity;
@Repository
public interface ConversationParticipantRepository extends CrudRepository<ConversationParticipantEntity, Integer>{
	@Query("select distinct cp.conversation.conversationId from ConversationParticipantEntity cp where cp.customer.customerId =:id")
	List<Integer> findByUser(@Param("id") int id);
}
