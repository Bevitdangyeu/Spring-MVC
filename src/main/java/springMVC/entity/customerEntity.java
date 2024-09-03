package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class customerEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	@Column(name="CustomerName")
	private String CustomerName;
	@Column(name="phoneNumber")
	private long phoneNumber;
	@Column(name="status")
	private int status;
	@OneToMany(mappedBy = "customer")
	private List<BillEntity> listBill=new ArrayList<BillEntity>();
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public List<BillEntity> getListBill() {
		return listBill;
	}
	public void setListBill(List<BillEntity> listBill) {
		this.listBill = listBill;
	}
	
}
