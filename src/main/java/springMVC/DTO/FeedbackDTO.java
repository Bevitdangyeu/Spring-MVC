package springMVC.DTO;

import java.util.List;
public class FeedbackDTO {
	private int reviewId;
	private String sizeColor;
	private int star;
	private String description;
	private String product;
	private String customer;
	private String date;
	private int billDetailId;
	private int productId;
	private List<ReplyDTO> reply;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<ReplyDTO> getReply() {
		return reply;
	}
	public void setReply(List<ReplyDTO> reply) {
		this.reply = reply;
	}
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
