package springMVC.service.Interface;
import java.util.List;

import springMVC.DTO.ConversationDTO;
public interface IConversationService {
	List<ConversationDTO> findByUser(int id);
	ConversationDTO findByConversationId(int id);
	
}
