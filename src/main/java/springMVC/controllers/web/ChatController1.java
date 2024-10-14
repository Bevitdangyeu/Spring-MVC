package springMVC.controllers.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springMVC.DTO.ConversationDTO;
import springMVC.DTO.CustomerDTO;
import springMVC.DTO.MessageDTO;
//import springMVC.service.Implement.ConversationService;
import springMVC.service.Implement.CustomerService;
import springMVC.service.Interface.IConversationService;
import springMVC.service.Interface.ICustomerService;
import springMVC.service.Interface.IMessageService;

@Controller
@RequestMapping("/user")
public class ChatController1 {
	@Autowired ICustomerService customer;
	@Autowired IConversationService conversationService;
	@Autowired IMessageService messageService;
	 @GetMapping("/chat")
	    public ModelAndView chatPage(@RequestParam("userId") int id) {
		 	ModelAndView mav=new ModelAndView("Chat");
		 	// danh sách tất cả user
		 	List<CustomerDTO> listCustomer=customer.findAll();
		 	// lấy danh sách đoạn chat của nguời dùng đó
		 	List<ConversationDTO> listConversationDTO=conversationService.findByUser(id);
		 	mav.addObject("conversation", listConversationDTO);// lấy tất cả đoạn chat theo user đó
		 	mav.addObject("customer", listCustomer); // lấy ra tất cả các user trong hê thống
	        return mav; // Trả về tên của trang JSP (chat.jsp)
	    }
	 @RequestMapping(value="/message",method = RequestMethod.POST)
	 @ResponseBody // chuyển giá trị trả về thành json
	 public List<MessageDTO> getMessage(@RequestBody ConversationDTO conversation) throws JsonProcessingException {
		 List<MessageDTO> list=messageService.findByConversation(conversation.getConversationId());// lấy ra chi tiết tin nhắn theo mã đoan chat
		 ModelAndView mav=new ModelAndView("chat");
		 mav.addObject("message",list);
		
		return list;
		 
	 }
	 @DeleteMapping("/delete")
	 public ResponseEntity<?> deleteMess(@RequestBody MessageDTO mesesage) {
		  messageService.deleteMess(mesesage);
		  return ResponseEntity.ok().build();
	 }
	 
	 @PostMapping("/conversation")
	 @ResponseBody
	 // lấy ra tin nhắn theo mã user của user hiện tại và  user nào đó
	 public List<MessageDTO> getMessageByUserId(@RequestBody Map<String,Integer> id){
		 List<MessageDTO> list=new ArrayList<MessageDTO>();
		 Optional<Integer> conversationId=conversationService.findConversationIdByUser(id.get("userActiveId"), id.get("currentUser"));
		 int conversation=conversationId.orElse(0);
		 if(conversation!=0) {
			list=messageService.findByConversation(conversation);
			 ModelAndView mav=new ModelAndView("chat");
			 mav.addObject("message",list);
			 return list;
		 }
		
		 return list;
	 }
}
