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
	@Column(name="billId")
	private int billId;
	@Column(name="productId")
	private int productId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="prince")
	private float prince;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="billid")
	private BillEntity bill;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productid")
	private ProductEntity product;
	public int getDetailBillId() {
		return detailBillId;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrince() {
		return prince;
	}
	public void setPrince(float prince) {
		this.prince = prince;
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
	
}
