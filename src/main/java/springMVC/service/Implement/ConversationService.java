package springMVC.service.Implement;

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
import springMVC.entity.ConversationParticipantEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.ConversationParticipantRepository;
import springMVC.repository.ConversationRepository;
import springMVC.service.Interface.IConversationService;
import springMVC.service.Interface.ICustomerService;
@Service
 public class ConversationService implements IConversationService {
	@Autowired ConversationRepository conversationRepository;
	@Autowired ICustomerService customerService;
	@Autowired ConversationParticipantRepository conversationParticipantRepository;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
	@Transactional
	@Override	
	public List<ConversationDTO> findByUser(int id) {
		
		List<Integer> idConversation=conversationParticipantRepository.findByUser(id);
		List<ConversationDTO> listDTO=new ArrayList<ConversationDTO>();
		for(int i=0;i<idConversation.size();i++) {
			ConversationEntity conversationEntity=new ConversationEntity();
			conversationEntity=conversationRepository.findByConversationId(idConversation.get(i));
			ConversationDTO conversation=new ConversationDTO();
			conversation.setConversationId(conversationEntity.getConversationId());
			MessageDTO mess=new MessageDTO();
			mess.setIdMessenge(conversationEntity.getLastMessage().getMessageId());
			mess.setContent(conversationEntity.getLastMessage().getContent());
			mess.setTime(conversationEntity.getCreatedAt().format(formatter))	;
			List<CustomerDTO> participant=new ArrayList<CustomerDTO>();
			for(int j=0;j<conversationEntity.getListParticipant().size();j++) {
				customerEntity customer=conversationEntity.getListParticipant().get(j).getCustomer();
				CustomerDTO customerDTO=new CustomerDTO();
				customerDTO.setCustomerId(customer.getCustomerId());
				customerDTO.setCustomerName(customer.getCustomerName());
				customerDTO.setImg(customer.getImg());
				participant.add(customerDTO);
				
			}
			
			conversation.setMessage(mess);
			conversation.setUser(participant);
			System.out.println(" customerid "+conversation.getUser().get(0).getCustomerId());
			listDTO.add(conversation);
		}
		return listDTO;
	}
	@Transactional
	@Override
	public ConversationDTO findByConversationId(int id) {
		ConversationEntity conversationEntity=conversationRepository.findByConversationId(id);
		ConversationDTO conversationDTO=new ConversationDTO();
		conversationDTO.setConversationId(conversationEntity.getConversationId());
		List<CustomerDTO> participant=new ArrayList<CustomerDTO>();
		for(int j=0;j<conversationEntity.getListParticipant().size();j++) {
			customerEntity customer=conversationEntity.getListParticipant().get(j).getCustomer();
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setImg(customer.getImg());
			participant.add(customerDTO);	
		}
		conversationDTO.setUser(participant);
		MessageDTO mess=new MessageDTO();
		mess.setIdMessenge(conversationEntity.getLastMessage().getMessageId());
		mess.setContent(conversationEntity.getLastMessage().getContent());
		mess.setTime(conversationEntity.getCreatedAt().format(formatter))	;
		conversationDTO.setMessage(mess);
		return conversationDTO;
	}
	
	
}
