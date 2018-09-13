package cn.atc.service;

import java.util.List;

import cn.atc.common.AllPerm;

public interface PermissionService {

	/**
	 * 获取权限信息
	 * @return
	 */
	List<AllPerm> getPerm();
}
