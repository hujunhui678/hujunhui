package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.Admin;

public interface AdminService {

	Admin doLogin(String loginName);// 登录

	Map<Object, Object> maps(String id);// 获取该用户所有角色的权限的集合
}
