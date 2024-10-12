package springMVC.controllers.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import springMVC.DTO.ConversationDTO;
import springMVC.DTO.MessageDTO;
import springMVC.service.Interface.IMessageService;

@Controller
public class ChatController {
	@Autowired IMessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send")
    @ResponseBody
    public void sendMessage(Message<MessageDTO> message) {
    	System.out.println(" vo ");
    	  MessageDTO mess = message.getPayload();
    	 ObjectMapper objectMapper = new ObjectMapper();    
    	    try {
    	    	// chuyển giá trị đã nhận thành chuỗi
    	    	String jsonString = objectMapper.writeValueAsString(mess);
    	    	// chuyển chuỗi đó thành đối tượng
    	    	MessageDTO messageDto=objectMapper.readValue(jsonString, MessageDTO.class);
    	    	// thêm một tin nhắn mới vào cơ sở dữ liệu 
    	    	MessageDTO messageResponse=messageService.save(messageDto);
    	    	// gửi đến những người nhận nào và gửi nội dung gì
    	    	for( int i=0;i<messageResponse.getReceiver().size();i++) {
    	    		 messagingTemplate.convertAndSend("/queue/"+messageResponse.getReceiver().get(i).getCustomerId(),messageResponse);
    	    	}
    	       
    	     //   messagingTemplate.convertAndSend("/queue/"+messageResponse.getSender().getCustomerId(),messageResponse);
    	    } catch (IOException e) {
    	    	System.out.println(" catch ");
    	        e.printStackTrace();
    	    }
    }
    
}
