package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Admin;
import cn.atc.util.PageUtil;

public interface PersonService {

	// ��ҳչʾ���й���Ա�Ļ�����Ϣ(����������Ϣ)
	PageUtil<Admin> getAllAdmin(Map<String, Object> maps);

	// ��ҳչʾ���й�Ա�Ļ�����Ϣ(����������Ϣ)
	PageUtil<Admin> getAllEmp(Map<String, Object> maps);

	Integer getAdminPhone(String phone);// �����ֻ��Ų���

	Integer addAdmin(Admin admin);// ��������Ա�û�

	Integer getAdminIdByPhone(String phone);// �����ֻ��Ų���ù���Ա��id;
}
