package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Admin;
import cn.atc.pojo.ChildDept;
import cn.atc.pojo.Employee;

public class EmpAndRole {
	private List<ChildDept> childDeptList;// ���е��Ӳ��ż���
	private List<Employee> employeeAnd;//��Ա����������Ϣ
	public List<ChildDept> getChildDeptList() {
		return childDeptList;
	}
	public void setChildDeptList(List<ChildDept> childDeptList) {
		this.childDeptList = childDeptList;
	}
	public List<Employee> getEmployeeAnd() {
		return employeeAnd;
	}
	public void setEmployeeAnd(List<Employee> employeeAnd) {
		this.employeeAnd = employeeAnd;
	}
	public EmpAndRole(List<ChildDept> childDeptList, List<Employee> employeeAnd) {
		super();
		this.childDeptList = childDeptList;
		this.employeeAnd = employeeAnd;
	}
	public EmpAndRole() {
		super();
	}
	
}
