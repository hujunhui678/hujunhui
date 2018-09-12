package cn.atc.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;

public interface AdminMapper {
	Admin doLogin(String loginName);// 登录
	
	Set<Role> rolesList(@Param("id") String adminId);// 此用户的所有角色

	Set<Permission> getPermOne(@Param("id") String adminId);// 获取当前用户的一级权限
	
	Set<Permission> getPermTwo(@Param("id") String adminId);// 获取当前用户的二级权限

	Set<Permission> getPermThree(@Param("id") String adminId);// 获取当前用户的三级权限
	

}
