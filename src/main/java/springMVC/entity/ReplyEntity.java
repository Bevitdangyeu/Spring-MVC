package springMVC.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class ReplyEntity {
	@Column(name="idReply")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyId;
	@Column(name="content",columnDefinition = "TEXT")
	private String content;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	private customerEntity customer;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="feedbackId")
	private FeedbackEntity feedback;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public customerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}
	public FeedbackEntity getFeedback() {
		return feedback;
	}
	public void setFeedback(FeedbackEntity feedback) {
		this.feedback = feedback;
	}
	public int getReplyId() {
		return replyId;
	}
	
}
