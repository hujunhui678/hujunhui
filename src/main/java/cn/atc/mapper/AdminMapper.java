package cn.atc.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;

public interface AdminMapper {
	Admin doLogin(String loginName);// ��¼
	
	Set<Role> rolesList(@Param("id") String adminId);// ���û������н�ɫ

	Set<Permission> getPermOne(@Param("id") String adminId);// ��ȡ��ǰ�û���һ��Ȩ��
	
	Set<Permission> getPermTwo(@Param("id") String adminId);// ��ȡ��ǰ�û��Ķ���Ȩ��

	Set<Permission> getPermThree(@Param("id") String adminId);// ��ȡ��ǰ�û�������Ȩ��
	

}
