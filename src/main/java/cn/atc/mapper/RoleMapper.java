package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Role;

public interface RoleMapper {
	// ��ȡ���н�ɫ����Ϣ����ҳ��
	List<Role> getAdminAndRoles(Map<String, Object> map);
	
	// ��ȡ���н�ɫ������
	Integer adminAndRolesCount();

	// ��ӽ�ɫ
	Integer addRole(Role role);

	// ��ɫ������
	Integer getCountByRoleName(String roleName);
	
	// ��ȡ������ɫ��Ϣ
	Role getRoleById(@Param("id")Integer id);
	
	// �޸Ľ�ɫ��Ϣ
	Integer updateRole(Role role);
	
	//����ɾ����ɫ��Ϣ
	Integer delRole(@Param("roleIds")String[] roleIds);
	
	//��ӽ�ɫ��Ϣ
	Integer addRoleByAdmin(Map<String, Object> maps);
}
