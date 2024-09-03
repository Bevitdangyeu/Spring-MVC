package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class PermissionEntity {
	@Id
	@Column(name="permissionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;
	@Column(name="permissionCode")
	private String permissionCode;
	@Column(name="permissionName")
	private String permissionName;
	@ManyToMany(mappedBy = "permissions")
	private List<RoleEntity> roles=new ArrayList<RoleEntity>();
	public String getPermissionCode() {
		return permissionCode;
	}
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public int getPermissionId() {
		return permissionId;
	}
	
}
