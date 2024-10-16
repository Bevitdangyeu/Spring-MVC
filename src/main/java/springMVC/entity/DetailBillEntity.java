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
@Table(name="detailbill")
public class DetailBillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="detailBillId")
	private int detailBillId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="total")
	private float total;
	@Column(name="price")
	private float price;
	@Column(name="color")
	private String color;
	@Column(name="size")
	private String size;
	@Column(name="isfeedbackd")
	private int feedbacked;
	@Column(name="image")
	private String img;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="billid")
	private BillEntity bill;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productid")
	private ProductEntity product;
	public int getDetailBillId() {
		return detailBillId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float prince) {
		this.price = prince;
	}
	public BillEntity getBill() {
		return bill;
	}
	public void setBill(BillEntity bill) {
		this.bill = bill;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setDetailBillId(int detailBillId) {
		this.detailBillId = detailBillId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getFeedbacked() {
		return feedbacked;
	}
	public void setFeedbacked(int feedbacked) {
		this.feedbacked = feedbacked;
	}
	
}
