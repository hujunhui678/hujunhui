package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role_perm;

public interface PermissionMapper {
	// ��ȡ1JȨ��
	List<AllPerm> getAllPermOne();

	// ��ȡ2JȨ��(�ɸ���1JȨ��)
	List<PermLv2> getAllPermTwo(@Param("parentPermId")long parentPermId);

	// ��ȡ3JȨ��(�ɸ���2JȨ��)
	List<Permission> getAllPermThr(@Param("parentPermId")long parentPermId);

	// ��ȡ��ɫ������һ��Ȩ��
	List<AllPerm> getPermByRoleIdOne(long id);

	// ��ȡ��ɫ�����ж���Ȩ��
	List<PermLv2> getPermByRoleIdTwo(long id);

	// ��ȡ��ɫ����������Ȩ��
	List<Permission> getPermByRoleIdThr(long id);
	
	// ���Ȩ��
	Integer insertPerm(Permission permission);
	
	//���ݽ�ɫIDɾ���������ɫ��صĽ�ɫȨ��
	Integer deleteRolePermByRoleId(@Param("roleId")Integer roleId);
	
	//���ݽ�ɫID��Ȩ��ID��ӽ�ɫȨ�����ӱ�
	Integer insertRolePermByRoleIdAndPermId(Role_perm role_perm);
}
