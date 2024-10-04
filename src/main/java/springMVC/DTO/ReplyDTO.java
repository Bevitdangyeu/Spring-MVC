package springMVC.DTO;

public class ReplyDTO {
	private int replyId;
	private String content;
	private CustomerDTO customer;
	private int feedback;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	
}
