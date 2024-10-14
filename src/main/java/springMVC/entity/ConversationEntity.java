package springMVC.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="conversation")
public class ConversationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="conversationId")
	private int conversationId;
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	@Column(name="name")
	private String name;
	@Column(name="img")
	private String img;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="lastMessage")
	private MessageEntity lastMessage;
	@OneToMany(mappedBy = "conversation",fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ConversationParticipantEntity> listParticipant;
	@OneToMany(mappedBy = "conversationId")
	private List<MessageEntity> message =new ArrayList<MessageEntity>();
	public List<MessageEntity> getMessage() {
		return message;
	}
	public void setMessage(List<MessageEntity> message) {
		this.message = message;
	}
	public int getConversationId() {
		return conversationId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public MessageEntity getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(MessageEntity lastMessage) {
		this.lastMessage = lastMessage;
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
	public List<ConversationParticipantEntity> getListParticipant() {
		return listParticipant;
	}
	public void setListParticipant(List<ConversationParticipantEntity> listParticipant) {
		this.listParticipant = listParticipant;
	}
	
}
