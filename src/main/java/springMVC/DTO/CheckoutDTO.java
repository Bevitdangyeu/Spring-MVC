package springMVC.DTO;



public class CheckoutDTO {
	private int billDetailId;
	private int productId;
	private String product;
	private Integer quantity;
	private Float prince;
	private Float total;
	private String size;
	private String color;
	private String image;
	private int feedbacked;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrince() {
		return prince;
	}
	public void setPrince(Float prince) {
		this.prince = prince;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getFeedbacked() {
		return feedbacked;
	}
	public void setFeedbacked(int feedbacked) {
		this.feedbacked = feedbacked;
	}
	
}
