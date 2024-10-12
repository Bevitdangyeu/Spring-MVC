package springMVC.service.Interface;
import java.util.List;

import springMVC.DTO.MessageDTO;
public interface IMessageService {
	List<MessageDTO> findByConversation(int id);
	MessageDTO save(MessageDTO mess);
	void deleteMess(MessageDTO mess);
}
