package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;
import cn.atc.util.PageUtil;

public interface PersonService {

	// 分页展示所有管理员的基本信息(包括部门信息)
	PageUtil<Admin> getAllAdmin(Map<String, Object> maps);

	// 分页展示所有雇员的基本信息(包括部门信息)
	PageUtil<Admin> getAllEmp(Map<String, Object> maps);

	Integer getAdminPhone(String phone);// 根据手机号查重

	Integer addAdmin(Admin admin);// 新增管理员用户
	Integer addEmp(Employee employee);// 新增雇员

	Integer getAdminIdByPhone(String phone);// 根据手机号查出该管理员的id;

	// 获得要修改的管理员的姓名和所属部门信息
	List<Admin> getAdminNameAndChildDept(Integer id);

	// 获得要修改的管理员的角色集合
	List<Admin_Role> getAdminAllRole(Integer id);

	// 修改管理员的信息(名字和子部门编号)
	Integer updateAdmin(Admin admin);
	// 修改雇员的信息
	Integer updateEmp(Employee emp);

	// 删除此管理员所有的角色
	Integer delAdminRole(@Param("adminId") Integer adminId);

	// 删除管理员
	Integer delAdmin(@Param("ids") String[] ids);

	// 删除雇员
	Integer delEmp(@Param("ids") String[] ids);
}
