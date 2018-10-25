package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;

public interface AdminService {

	Admin doLogin(String loginName);// 登录

	Map<Object, Object> maps(String id);// 获取该用户所有角色的权限的集合

	Admin getAdmin(@Param("id") Integer id);// 获取要修改资料的管理员信息

	Integer updateAdmin(Admin admin);// 修改管理员信息

	Admin getAdminByLoginName(@Param("loginName") String loginName);// 获取管理员信息

	Integer getAdminByLoginNameModifyCount(@Param("id") Integer id);// 查看该管理员是否修改过登录名

	Integer updatePwd(Admin admin);// 修改密码

	Integer addLoginLog(LoginLog log);// 登录成功之后插入登录日志表

	List<Admin> queryAll();// 查询所有用户
}
