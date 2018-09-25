package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;

public interface AdminService {

	Admin doLogin(String loginName);// ��¼

	Map<Object, Object> maps(String id);// ��ȡ���û����н�ɫ��Ȩ�޵ļ���

	Admin getAdmin(@Param("id") Integer id);// ��ȡҪ�޸����ϵĹ���Ա��Ϣ

	Integer updateAdmin(Admin admin);// �޸Ĺ���Ա��Ϣ

	Integer getAdminByLoginNameModifyCount(@Param("id") Integer id);// �鿴�ù���Ա�Ƿ��޸Ĺ���¼��

	Integer updatePwd(Admin admin);//�޸�����
}
