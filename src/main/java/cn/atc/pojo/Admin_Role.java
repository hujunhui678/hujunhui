package cn.atc.pojo;

/*
 * 人员角色表
 */
public class Admin_Role {
	private long id;// 人员角色表编号
	private long adminId;// 人员编号外键
	private long roleId;// 角色编号外键

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Admin_Role(long id, long adminId, long roleId) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.roleId = roleId;
	}

	public Admin_Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
