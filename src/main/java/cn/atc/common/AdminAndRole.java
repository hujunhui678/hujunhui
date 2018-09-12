package cn.atc.common;

import java.util.List;

import cn.atc.pojo.ChildDept;
import cn.atc.pojo.Role;

public class AdminAndRole {
	private List<Role> roleList;
	private List<ChildDept> childDeptList;
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
	public AdminAndRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminAndRole(List<Role> roleList, List<ChildDept> childDeptList) {
		super();
		this.roleList = roleList;
		this.childDeptList = childDeptList;
	}
	
}
