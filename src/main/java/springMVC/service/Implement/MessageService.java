package springMVC.service.Implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.ConversationDTO;
import springMVC.DTO.CustomerDTO;
import springMVC.DTO.MessageDTO;
import springMVC.entity.ConversationEntity;
import springMVC.entity.MessageEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.ConversationRepository;
import springMVC.repository.CustomerResponsitory;
import springMVC.repository.MessageRepository;
import springMVC.service.Interface.IConversationService;
import springMVC.service.Interface.ICustomerService;
import springMVC.service.Interface.IMessageService;
@Service
public class MessageService implements IMessageService{
	@Autowired MessageRepository messageRepository;
	@Autowired IConversationService conversationService;
	@Autowired CustomerResponsitory customerRepository;
	@Autowired ConversationRepository conversationRepository;
	@Autowired ICustomerService customer;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
	@Override
	public List<MessageDTO> findByConversation(int id) {
		
		List<MessageEntity> listMessageEntity= messageRepository.findByConversation(id);
		ConversationDTO conversation=conversationService.findByConversationId(id);
		List<MessageDTO> listMessageDTO= new ArrayList<MessageDTO>();
		for(int i=0;i<listMessageEntity.size();i++) {
			MessageDTO message=new MessageDTO();
			message.setIdMessenge(listMessageEntity.get(i).getMessageId());
			message.setConversationId(listMessageEntity.get(i).getConversationId().getConversationId());
			message.setContent(listMessageEntity.get(i).getContent());
			CustomerDTO customer=new CustomerDTO();
			customer.setCustomerId(listMessageEntity.get(i).getSenderId().getCustomerId());
			customer.setCustomerName(listMessageEntity.get(i).getSenderId().getCustomerName());
			customer.setImg(listMessageEntity.get(i).getSenderId().getImg());
			message.setSender(customer);
			message.setTime(listMessageEntity.get(i).getTime().format(formatter));
			message.setReceiver(conversation.getUser());
			listMessageDTO.add(message);
		}
		return listMessageDTO;
	}
	@Transactional
	@Override
	public MessageDTO save(MessageDTO mess) {
		// chuyển từ dto sang entity
		ConversationDTO conversation=conversationService.findByConversationId(mess.getConversationId());
		LocalDateTime currentDateTime = LocalDateTime.now();
		MessageEntity messageEntity=new MessageEntity();
		messageEntity.setContent(mess.getContent());
		messageEntity.setTime(currentDateTime);
		customerEntity sender=customerRepository.findByCustomerId(mess.getSender().getCustomerId());
		messageEntity.setSenderId(sender);
		ConversationEntity conversationEntity=conversationRepository.findByConversationId(mess.getConversationId());
		messageEntity.setConversationId(conversationEntity);
		MessageEntity messEntity=messageRepository.save(messageEntity);
		// chuyển ngược lại dto
		MessageDTO dto=new MessageDTO();
		dto.setConversationId(messEntity.getConversationId().getConversationId());
		dto.setContent(messEntity.getContent());
		dto.setIdMessenge(messEntity.getMessageId());
		dto.setSender(customer.findByCustomerId(messEntity.getSenderId().getCustomerId()));
		dto.setTime(messageEntity.getTime().format(formatter));
		dto.setReceiver(conversation.getUser());
		return dto;
	}
	@Override
	public void deleteMess(MessageDTO mess) {
		// lấy đối tượng đó lên từ cơ sở dữ liệu
		MessageEntity messEntity=messageRepository.findByMessageId(mess.getIdMessenge());
		messageRepository.delete(messEntity);
		
		
	}
	
}
