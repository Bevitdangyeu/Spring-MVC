package springMVC.service.Interface;
import java.util.List;
import java.util.Optional;

import springMVC.DTO.ConversationDTO;
public interface IConversationService {
	List<ConversationDTO> findByUser(int id);
	ConversationDTO findByConversationId(int id);
	Optional<Integer> findConversationIdByUser(int userActiveId,int currentUser);
	
}
