package springMVC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import springMVC.entity.ConversationEntity;
@Repository
public interface ConversationRepository extends CrudRepository<ConversationEntity, Integer>{
	ConversationEntity findByConversationId ( int conversationId);
	@Query(" select c.conversationId "
		 + " from ConversationEntity c inner join ConversationParticipantEntity cp on c.conversationId=cp.conversation.conversationId"
		 + " where cp.customer.customerId in( :user1, :user2) "
		 + " group by(c.conversationId) "
		 + " having count( distinct cp.customer.customerId) = 2")
	Optional<Integer> findByUserId(@Param("user1") int user1,@Param("user2") int user2);

}
