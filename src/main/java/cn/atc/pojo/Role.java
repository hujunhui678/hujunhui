package cn.atc.pojo;

import java.util.List;

public class Role {
	/*
	 * 角色表
	 */
	private long id;// 角色表编号
	private String roleName;// 角色名称
	private String roleDesc;// 角色的描述信息

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(long id, String roleName, String roleDesc) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

}
