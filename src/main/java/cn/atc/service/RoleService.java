package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Role;
import cn.atc.util.PageUtil;

public interface RoleService {
	// ��ȡ���н�ɫ��Ϣ����ҳ��
	PageUtil<Role> getAdminAndRoles(Map<String, Object> map);

	// ��ȡ��ɫ����(����)
	List<Role> getRole();

	//��ȡ��ɫ����(���³���)
	List<Role> getRoleNoRole(Map<String, Object> map);
	
	// ��ӽ�ɫ
	Integer addRole(Role role);

	// ��ɫ����
	Integer getCountByRoleName(String roleName);

	// ��ȡ������ɫ��Ϣ
	Role getRoleById(@Param("id") Integer id);

	// �޸Ľ�ɫ��Ϣ
	Integer updateRole(Role role);

	// ����ɾ����ɫ��Ϣ
	Integer delRole(@Param("roleIds") String[] ids);

	// ��ӽ�ɫ��Ϣ
	Integer addRole(Map<String, Object> maps);

	
}
