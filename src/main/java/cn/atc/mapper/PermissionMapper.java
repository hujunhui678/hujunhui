package cn.atc.mapper;

import java.util.List;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.pojo.Permission;

public interface PermissionMapper {
	//获取1J权限
	List<AllPerm> getAllPermOne();

	//根据1J权限获取2J权限
	List<PermLv2> getAllPermTwo(long parentPermId);
	
	//根据2J权限获取3J权限
	List<Permission> getAllPermThr(long parentPermId);
}
