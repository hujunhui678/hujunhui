package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.Admin;

public interface AdminService {

	Admin doLogin(String loginName);// ��¼

	Map<Object, Object> maps(String id);// ��ȡ���û����н�ɫ��Ȩ�޵ļ���
}
