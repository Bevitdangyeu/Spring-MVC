package springMVC.DTO;

import java.util.List;

public class ConversationDTO {
	private int conversationId;
	private List<CustomerDTO> user;
	private String name;
	private String img;
	private MessageDTO message;
	public int getConversationId() {
		return conversationId;
	}
	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}
	
	public MessageDTO getMessage() {
		return message;
	}
	public void setMessage(MessageDTO message) {
		this.message = message;
	}
	public List<CustomerDTO> getUser() {
		return user;
	}
	public void setUser(List<CustomerDTO> user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
