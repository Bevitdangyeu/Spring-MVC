package springMVC.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import springMVC.entity.ConversationEntity;
@Repository
public interface ConversationRepository extends CrudRepository<ConversationEntity, Integer>{
	ConversationEntity findByConversationId ( int conversationId);
}
