package springMVC.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class MessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="messageId")
	private int messageId;
	@Column(name="content",columnDefinition = "TEXT")
	private String content;
	@Column(name="time")
	private LocalDateTime time;
	@Column(name="status")
	private String status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="senderId")
	private customerEntity senderId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="conversationId")
	private ConversationEntity conversationId;
	@OneToOne(mappedBy = "lastMessage")
	private ConversationEntity conversation;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public int getMessageId() {
		return messageId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public customerEntity getSenderId() {
		return senderId;
	}
	public void setSenderId(customerEntity senderId) {
		this.senderId = senderId;
	}
	public ConversationEntity getConversationId() {
		return conversationId;
	}
	public void setConversationId(ConversationEntity conversationId) {
		this.conversationId = conversationId;
	}
	public ConversationEntity getConversation() {
		return conversation;
	}
	public void setConversation(ConversationEntity conversation) {
		this.conversation = conversation;
	}
	
}
