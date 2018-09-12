package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Admin;

public interface PersonMapper {
	// չʾ���й���Ա�Ļ�����Ϣ(����������Ϣ)
	List<Admin> getAllAdmin(Map<String, Object> maps);

	// ��ȡ����Ա����
	Integer getAdminToCount();

	// չʾ���й�Ա�Ļ�����Ϣ(����������Ϣ)
	List<Admin> getAllEmp(Map<String, Object> maps);

	// ��ȡ��Ա����
	Integer getEmpToCount();

	Integer getAdminPhone(String phone);// �����ֻ��Ų���

	Integer addAdmin(Admin admin);// ��������Ա�û�
	
	Integer getAdminIdByPhone(String phone);//�����ֻ��Ų���ù���Ա��id;
}
