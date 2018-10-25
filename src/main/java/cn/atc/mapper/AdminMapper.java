package cn.atc.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;

public interface AdminMapper {
	Admin doLogin(String loginName);// ��¼

	Set<Role> rolesList(@Param("id") String adminId);// ���û������н�ɫ(Shiro)

	Set<Permission> getPermOne(@Param("id") String adminId);// ��ȡ��ǰ�û���һ��Ȩ��(Shiro)

	Set<Permission> getPermTwo(@Param("id") String adminId);// ��ȡ��ǰ�û��Ķ���Ȩ��(Shiro)

	Set<Permission> getPermThree(@Param("id") String adminId);// ��ȡ��ǰ�û�������Ȩ��(Shiro)

	Admin getAdmin(@Param("id") Integer id);// ��ȡҪ�޸����ϵĹ���Ա��Ϣ

	Admin getAdminByLoginName(@Param("loginName") String loginName);// ��ȡ����Ա��Ϣ

	Integer updateAdmin(Admin admin);// �޸Ĺ���Ա��Ϣ

	Integer getAdminByLoginNameModifyCount(@Param("id") Integer id);// �鿴�ù���Ա�Ƿ��޸Ĺ���¼��

	Integer updatePwd(Admin admin);// �޸�����

	Integer addLoginLog(LoginLog log);// ��¼�ɹ�֮������¼��־��

	List<Admin> queryAll();// ��ѯ�����û�
}
