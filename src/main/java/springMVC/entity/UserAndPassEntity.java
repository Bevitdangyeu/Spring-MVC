package springMVC.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserAndPass")

public class UserAndPassEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="pass")
	private String pass;
	@Column(name="status")
	private  int status;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="userrole",
			  joinColumns = @JoinColumn(name="userId"),
			  inverseJoinColumns = @JoinColumn(name="roleId")
	)	
	private List<RoleEntity> roles=new ArrayList<RoleEntity>();
	@OneToOne(mappedBy = "userId")
	private customerEntity customerId;
	public int getId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<RoleEntity> getRole() {
		return roles;
	}
	public void setRole(List<RoleEntity> role) {
		this.roles = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public customerEntity getCustomerId() {
		return customerId;
	}
	public void setCustomerId(customerEntity customerId) {
		this.customerId = customerId;
	}
	
}
