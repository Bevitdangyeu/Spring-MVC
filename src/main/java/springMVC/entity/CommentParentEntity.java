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
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentParentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="commentParentId")
	private int commentParentId;
	@Column(name="content")
	private String content;
	@Column(name="time")
	private LocalDateTime time;
	// người cmt
	@ManyToOne(fetch =FetchType.EAGER )
	@JoinColumn(name="customerId")
	private customerEntity customer;
	// sản phẩm mà nguời đó cmt 
	public int getCommentParentId() {
		return commentParentId;
	}
	public void setCommentParentId(int commentParentId) {
		this.commentParentId = commentParentId;
	}
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
	public customerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}
	
	
}
