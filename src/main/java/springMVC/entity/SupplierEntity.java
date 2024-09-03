package springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class SupplierEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SupplierId")
	private int supplierId;
	@Column(name="supplierName")
	private String supplierName;
	@Column(name="status")
	private int status;
	public SupplierEntity() {
	}
	public SupplierEntity(int supplierId, String supplierName, int status) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.status = status;
	}
	public int getSupplierId() {
		return supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
