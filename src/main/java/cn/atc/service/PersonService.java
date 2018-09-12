package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Admin;
import cn.atc.util.PageUtil;

public interface PersonService {

	// 分页展示所有管理员的基本信息(包括部门信息)
	PageUtil<Admin> getAllAdmin(Map<String, Object> maps);

	// 分页展示所有雇员的基本信息(包括部门信息)
	PageUtil<Admin> getAllEmp(Map<String, Object> maps);

	Integer getAdminPhone(String phone);// 根据手机号查重

	Integer addAdmin(Admin admin);// 新增管理员用户

	Integer getAdminIdByPhone(String phone);// 根据手机号查出该管理员的id;
}
