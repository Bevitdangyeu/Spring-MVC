package springMVC.DTO;
import java.util.List;
public class MessageDTO {
	private int idMessenge;
	private int conversationId;
	private String time;
	private String content;
	private String status;
	private CustomerDTO sender;
	private List<CustomerDTO> receiver;
	public int getIdMessenge() {
		return idMessenge;
	}
	public void setIdMessenge(int idMessenge) {
		this.idMessenge = idMessenge;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getConversationId() {
		return conversationId;
	}
	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerDTO getSender() {
		return sender;
	}
	public void setSender(CustomerDTO sender) {
		this.sender = sender;
	}
	public List<CustomerDTO> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<CustomerDTO> receiver) {
		this.receiver = receiver;
	}
	
	
}
