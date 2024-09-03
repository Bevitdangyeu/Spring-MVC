package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EmployeeId")
	private int  employeeId;
	@Column(name="EmployeeName")
	private String employeeName;
	@Column(name="status")
	private int status;
	@OneToMany(mappedBy = "employee")
	private List<BillEntity> listBill=new ArrayList<BillEntity>();
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<BillEntity> getListBill() {
		return listBill;
	}
	public void setListBill(List<BillEntity> listBill) {
		this.listBill = listBill;
	}
	
	
	
}
