
package springMVC.entity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class BillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billId")
	private int billId;
	@Column(name="totalBill")
	private int totalBill;
	@Column(name="totalQuantity")
	private int totalQuantity;
	@Column(name="totalPrice")
	private int totalPrice;
	@Column(name="date")
	private Timestamp date;
	@ManyToMany
	@JoinTable( name="detailBill",
				joinColumns=@JoinColumn(name="billId"),
				inverseJoinColumns = @JoinColumn(name="productId")
			)
	List<ProductEntity> product=new ArrayList<ProductEntity>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	private customerEntity customer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private EmployeeEntity employee;
	@OneToMany(mappedBy = "bill")
	private List<DetailBillEntity> list=new ArrayList<DetailBillEntity>();
	public int getBillId() {
		return billId;
	}
	
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public List<ProductEntity> getProduct() {
		return product;
	}
	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}
	public customerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	public List<DetailBillEntity> getList() {
		return list;
	}
	public void setList(List<DetailBillEntity> list) {
		this.list = list;
	}
	
}

