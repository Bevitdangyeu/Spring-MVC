package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class customerEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	@Column(name="CustomerName")
	private String customerName;
	@Column(name="phoneNumber")
	private long phoneNumber;
	@Column(name="address")
	private String address;
	@Column(name="status")
	private int status;
	@Column(name="img")
	private String img;
	@OneToMany(mappedBy = "customer")
	private List<BillEntity> listBill=new ArrayList<BillEntity>();
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private UserAndPassEntity userId;
	@OneToMany(mappedBy = "customer")
	private List<FeedbackEntity> feedback=new ArrayList<FeedbackEntity>();
	@OneToMany(mappedBy = "customer")
	private List<ReplyEntity> reply=new ArrayList<ReplyEntity>();
	@OneToMany(mappedBy = "customer")
	private List<ConversationParticipantEntity> participant=new ArrayList<ConversationParticipantEntity>();
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<BillEntity> getListBill() {
		return listBill;
	}
	public void setListBill(List<BillEntity> listBill) {
		this.listBill = listBill;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserAndPassEntity getUserId() {
		return userId;
	}
	public void setUserId(UserAndPassEntity userId) {
		this.userId = userId;
	}
	public List<FeedbackEntity> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<FeedbackEntity> feedback) {
		this.feedback = feedback;
	}
	public List<ReplyEntity> getReply() {
		return reply;
	}
	public void setReply(List<ReplyEntity> reply) {
		this.reply = reply;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<ConversationParticipantEntity> getParticipant() {
		return participant;
	}
	public void setParticipant(List<ConversationParticipantEntity> participant) {
		this.participant = participant;
	}
	
}
