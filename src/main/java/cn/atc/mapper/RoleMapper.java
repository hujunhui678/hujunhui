package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Role;

public interface RoleMapper {
	// 获取所有角色的信息（分页）
	List<Role> getAdminAndRoles(Map<String, Object> map);
	
	// 获取所有角色的数量
	Integer adminAndRolesCount();

	// 添加角色
	Integer addRole(Role role);

	// 角色名查重
	Integer getCountByRoleName(String roleName);
	
	// 获取单个角色信息
	Role getRoleById(@Param("id")Integer id);
	
	// 修改角色信息
	Integer updateRole(Role role);
	
	//批量删除角色信息
	Integer delRole(@Param("roleIds")String[] roleIds);
	
	//添加角色信息
	Integer addRoleByAdmin(Map<String, Object> maps);
}
