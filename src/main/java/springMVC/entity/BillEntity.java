
package springMVC.entity;
import java.sql.Timestamp;
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
	@Column(name="totalQuantity")
	private int totalQuantity;
	@Column(name="totalPrice")
	private float totalPrice;
	@Column(name="date")
	private LocalDateTime date;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private customerEntity customer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employeeId")
	private EmployeeEntity employee;
	// khi thêm bill sẽ tự động thêm detail bill 
	@OneToMany(mappedBy = "bill",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private List<DetailBillEntity> list=new ArrayList<DetailBillEntity>();
	public int getBillId() {
		return billId;
	}
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime currentDateTime) {
		this.date = currentDateTime;
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

