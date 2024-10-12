package springMVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import springMVC.entity.MessageEntity;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Integer>{
	@Query("select m from MessageEntity m where m.conversationId.conversationId =:id")
	List<MessageEntity> findByConversation(@Param("id") int id);
	MessageEntity findByMessageId(int messageId);
 
}
