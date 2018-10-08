package cn.atc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.RoleMapper;
import cn.atc.pojo.Admin;
import cn.atc.pojo.Role;
import cn.atc.service.RoleService;
import cn.atc.util.PageUtil;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public PageUtil<Role> getAdminAndRoles(Map<String, Object> map) {
		PageUtil<Role> page = new PageUtil<Role>();
		Integer totalCount = roleMapper.adminAndRolesCount();
		page.setPageSize((Integer)map.get("pageSize"));
		page.setTotalCount(totalCount);
		page.setCurrentPage((Integer)map.get("currentPage"));
		map.put("startRow",((Integer)map.get("currentPage")-1)*(Integer)map.get("pageSize"));
		page.setLists(roleMapper.getAdminAndRoles(map));
		return page;
	}

	@Override
	public Integer addRole(Role role) {
		return roleMapper.addRole(role);
	}

	@Override
	public Integer getCountByRoleName(String roleName) {
		return roleMapper.getCountByRoleName(roleName);
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleMapper.getRoleById(id);
	}

	@Override
	public Integer updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

	@Override
	public Integer delRole(String[] roleIds) {
		return roleMapper.delRole(roleIds);
	}

	@Override
	public List<Role> getRole() {
		return roleMapper.getAdminAndRoles(null);
	}

	@Override
	public Integer addRole(Map<String, Object> maps) {
		return roleMapper.addRoleByAdmin(maps);
	}
	
	@Override
	public List<Role> getRoleNoRole(Map<String, Object> map) {
		map.put("noRole", "1");
		return roleMapper.getAdminAndRoles(map);
	}
}
