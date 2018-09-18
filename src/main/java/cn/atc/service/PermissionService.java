package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.common.AllPerm;
import cn.atc.pojo.Permission;

public interface PermissionService {

	/**
	 * 获取权限信息(所有的权限)
	 * @return 一级权限集合
	 */
	List<AllPerm> getPerm();
	
	/**
	 * 获取权限信息(根据角色Id获取权限)
	 * @return 一级权限集合
	 */
	List<AllPerm> getPermByRoleId(long id);
	
	/**
	 * 根据条件获取1J或2J所有权限，转换成Permission类返回
	 * @param permLevel 权限管理页面选择的权限等级
	 * @param parentPermId 父级权限ID，用来做重载
	 * @return
	 */
	List<Permission> getAllPermConverterPerm(Integer permLevel);
	
	// 添加权限
	boolean insertPerm(Permission permission);
	
	// 添加角色权限连接表数据
	boolean insertRolePermByRoleIdAndPermId(Map<String, Object> map);
}
