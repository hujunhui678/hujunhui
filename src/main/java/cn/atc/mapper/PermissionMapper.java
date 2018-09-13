package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.pojo.Permission;

public interface PermissionMapper {
	// 获取1J权限
	List<AllPerm> getAllPermOne();

	// 获取2J权限(可根据1J权限)
	List<PermLv2> getAllPermTwo(@Param("parentPermId")long parentPermId);

	// 获取3J权限(可根据2J权限)
	List<Permission> getAllPermThr(@Param("parentPermId")long parentPermId);

	// 获取角色的所有一级权限
	List<AllPerm> getPermByRoleIdOne(long id);

	// 获取角色的所有二级权限
	List<PermLv2> getPermByRoleIdTwo(long id);

	// 获取角色的所有三级权限
	List<Permission> getPermByRoleIdThr(long id);
	
}
