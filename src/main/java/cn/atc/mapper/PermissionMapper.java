package cn.atc.mapper;

import java.util.List;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.pojo.Permission;

public interface PermissionMapper {
	//��ȡ1JȨ��
	List<AllPerm> getAllPermOne();

	//����1JȨ�޻�ȡ2JȨ��
	List<PermLv2> getAllPermTwo(long parentPermId);
	
	//����2JȨ�޻�ȡ3JȨ��
	List<Permission> getAllPermThr(long parentPermId);
}
