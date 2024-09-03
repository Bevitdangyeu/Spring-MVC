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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleId")
	private int roleId;
	@Column(name="roleCode")
	private String roleCode;
	@Column(name="roleName")
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	List<UserAndPassEntity> list=new ArrayList<UserAndPassEntity>();
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_permission",
				joinColumns = @JoinColumn(name="roleId"),
				inverseJoinColumns = @JoinColumn(name="permissionId")
	)
	private List<PermissionEntity> permissions=new ArrayList<PermissionEntity>();
	
	public List<PermissionEntity> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}

	public int getRoleId() {
		return roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserAndPassEntity> getList() {
		return list;
	}
	public void setList(List<UserAndPassEntity> list) {
		this.list = list;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
}
