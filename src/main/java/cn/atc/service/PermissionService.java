package cn.atc.service;

import java.util.List;

import cn.atc.common.AllPerm;

public interface PermissionService {

	/**
	 * ��ȡȨ����Ϣ
	 * @return
	 */
	List<AllPerm> getPerm();
}
