package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.common.AllPerm;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;

public interface PersonMapper {
	// 展示所有管理员的基本信息(包括部门信息)
	List<Admin> getAllAdmin(Map<String, Object> maps);

	// 获取管理员数量
	Integer getAdminToCount();

	// 展示所有雇员的基本信息(包括部门信息)
	List<Admin> getAllEmp(Map<String, Object> maps);

	// 获取雇员数量
	Integer getEmpToCount();

	Integer getAdminPhone(String phone);// 根据手机号查重

	Integer addAdmin(Admin admin);// 新增管理员用户

	Integer addEmp(Employee employee);// 新增雇员

	Integer getAdminIdByPhone(String phone);// 根据手机号查出该管理员的id;

	// 获得要修改的管理员的姓名和所属部门信息
	List<Admin> getAdminNameAndChildDept(Integer id);
	// 获得要修改的雇员信息和所属部门信息
	List<Employee> getEmpAndChildDept(Integer id);
	
	
	
	// 获得要修改的管理员的角色集合
	List<Admin_Role> getAdminAllRole(Integer id);

	// 修改管理员的信息(名字和子部门编号)
	Integer updateAdmin(Admin admin);
	
	// 修改雇员的信息
	Integer updateEmp(Employee emp);

	// 删除此管理员所有的角色
	Integer delAdminRole(@Param("adminId") Integer adminId);

	// 删除管理员
	Integer delAdmin(@Param("adminIds") String[] ids);

	// 删除雇员
	Integer delEmp(@Param("empIds") String[] ids);

}
