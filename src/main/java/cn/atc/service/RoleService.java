package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Role;
import cn.atc.util.PageUtil;

public interface RoleService {
	// 获取所有角色信息（分页）
	PageUtil<Role> getAdminAndRoles(Map<String, Object> map);

	// 获取角色集合(所有)
	List<Role> getRole();

	//获取角色集合(人事除外)
	List<Role> getRoleNoRole(Map<String, Object> map);
	
	// 添加角色
	Integer addRole(Role role);

	// 角色查重
	Integer getCountByRoleName(String roleName);

	// 获取单个角色信息
	Role getRoleById(@Param("id") Integer id);

	// 修改角色信息
	Integer updateRole(Role role);

	// 批量删除角色信息
	Integer delRole(@Param("roleIds") String[] ids);

	// 添加角色信息
	Integer addRole(Map<String, Object> maps);

	
}
