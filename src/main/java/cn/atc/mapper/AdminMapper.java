package cn.atc.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;

public interface AdminMapper {
	Admin doLogin(String loginName);// 登录

	Set<Role> rolesList(@Param("id") String adminId);// 此用户的所有角色(Shiro)

	Set<Permission> getPermOne(@Param("id") String adminId);// 获取当前用户的一级权限(Shiro)

	Set<Permission> getPermTwo(@Param("id") String adminId);// 获取当前用户的二级权限(Shiro)

	Set<Permission> getPermThree(@Param("id") String adminId);// 获取当前用户的三级权限(Shiro)

	Admin getAdmin(@Param("id") Integer id);// 获取要修改资料的管理员信息

	Admin getAdminByLoginName(@Param("loginName") String loginName);// 获取管理员信息

	Integer updateAdmin(Admin admin);// 修改管理员信息

	Integer getAdminByLoginNameModifyCount(@Param("id") Integer id);// 查看该管理员是否修改过登录名

	Integer updatePwd(Admin admin);// 修改密码

	Integer addLoginLog(LoginLog log);// 登录成功之后插入登录日志表

	List<Admin> queryAll();// 查询所有用户
}
