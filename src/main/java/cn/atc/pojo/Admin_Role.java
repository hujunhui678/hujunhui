package cn.atc.pojo;

/*
 * ��Ա��ɫ��
 */
public class Admin_Role {
	private long id;// ��Ա��ɫ����
	private long adminId;// ��Ա������
	private long roleId;// ��ɫ������

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
