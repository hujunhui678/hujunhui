package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;
import cn.atc.util.PageUtil;

public interface PersonService {

	// ��ҳչʾ���й���Ա�Ļ�����Ϣ(����������Ϣ)
	PageUtil<Admin> getAllAdmin(Map<String, Object> maps);

	// ��ҳչʾ���й�Ա�Ļ�����Ϣ(����������Ϣ)
	PageUtil<Admin> getAllEmp(Map<String, Object> maps);

	Integer getAdminPhone(String phone);// �����ֻ��Ų���

	Integer addAdmin(Admin admin);// ��������Ա�û�
	Integer addEmp(Employee employee);// ������Ա

	Integer getAdminIdByPhone(String phone);// �����ֻ��Ų���ù���Ա��id;

	// ���Ҫ�޸ĵĹ���Ա������������������Ϣ
	List<Admin> getAdminNameAndChildDept(Integer id);

	// ���Ҫ�޸ĵĹ���Ա�Ľ�ɫ����
	List<Admin_Role> getAdminAllRole(Integer id);

	// �޸Ĺ���Ա����Ϣ(���ֺ��Ӳ��ű��)
	Integer updateAdmin(Admin admin);
	// �޸Ĺ�Ա����Ϣ
	Integer updateEmp(Employee emp);

	// ɾ���˹���Ա���еĽ�ɫ
	Integer delAdminRole(@Param("adminId") Integer adminId);

	// ɾ������Ա
	Integer delAdmin(@Param("ids") String[] ids);

	// ɾ����Ա
	Integer delEmp(@Param("ids") String[] ids);
}
