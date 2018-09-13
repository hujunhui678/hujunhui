package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.ChildDept;
import cn.atc.pojo.Role;

public class AdminAndRole {
	private List<Role> roleList;// ���еĽ�ɫ����
	private List<ChildDept> childDeptList;// ���е��Ӳ��ż���

	private List<Admin_Role> AdminRoleList;// ���ָ������Աӵ�еĽ�ɫ����
	private List<Admin> childDeptId;// ���ָ������Ա����������������Ϣ

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<ChildDept> getChildDeptList() {
		return childDeptList;
	}

	public void setChildDeptList(List<ChildDept> childDeptList) {
		this.childDeptList = childDeptList;
	}

	public List<Admin_Role> getAdminRoleList() {
		return AdminRoleList;
	}

	public void setAdminRoleList(List<Admin_Role> adminRoleList) {
		AdminRoleList = adminRoleList;
	}

	public List<Admin> getChildDeptId() {
		return childDeptId;
	}

	public void setChildDeptId(List<Admin> childDeptId) {
		this.childDeptId = childDeptId;
	}

	public AdminAndRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminAndRole(List<Role> roleList, List<ChildDept> childDeptList) {
		super();
		this.roleList = roleList;
		this.childDeptList = childDeptList;
	}

	public AdminAndRole(List<Role> roleList, List<ChildDept> childDeptList, List<Admin_Role> adminRoleList,
			List<Admin> childDeptId) {
		super();
		this.roleList = roleList;
		this.childDeptList = childDeptList;
		AdminRoleList = adminRoleList;
		this.childDeptId = childDeptId;
	}

	
}
