package springMVC.entity;

import java.time.LocalDateTime;
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
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class FeedbackEntity {
	@Column(name="feedbackId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	@Column(name="size_color")
	private String sizeColor;
	
	@Column(name="star")
	private int star;
	@Column(name="description",columnDefinition = "TEXT")
	private String description;
	@Column(name="date")
	private LocalDateTime date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId")
	private ProductEntity product;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	private customerEntity customer;
	@OneToMany(mappedBy = "feedback")
	private List<ReplyEntity> reply=new ArrayList<ReplyEntity>();
	public String getSizeColor() {
		return sizeColor;
	}
	public void setSizeColor(String sizeColor) {
		this.sizeColor = sizeColor;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public customerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}
	
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public List<ReplyEntity> getReply() {
		return reply;
	}
	public void setReply(List<ReplyEntity> reply) {
		this.reply = reply;
	}
	
}
