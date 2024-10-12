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
@Table(name="ConversationParticipant")
public class ConversationParticipantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="participantId")
	private int participantId;
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="conversation")
	private ConversationEntity conversation;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private customerEntity customer;
	public ConversationEntity getConversation() {
		return conversation;
	}
	public void setConversation(ConversationEntity conversation) {
		this.conversation = conversation;
	}
	public customerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}
	public int getParticipantId() {
		return participantId;
	}
	
}
