package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.common.AllPerm;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;

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

	Integer addEmp(Employee employee);// ������Ա

	Integer getAdminIdByPhone(String phone);// �����ֻ��Ų���ù���Ա��id;

	// ���Ҫ�޸ĵĹ���Ա������������������Ϣ
	List<Admin> getAdminNameAndChildDept(Integer id);
	// ���Ҫ�޸ĵĹ�Ա��Ϣ������������Ϣ
	List<Employee> getEmpAndChildDept(Integer id);
	
	
	
	// ���Ҫ�޸ĵĹ���Ա�Ľ�ɫ����
	List<Admin_Role> getAdminAllRole(Integer id);

	// �޸Ĺ���Ա����Ϣ(���ֺ��Ӳ��ű��)
	Integer updateAdmin(Admin admin);
	
	// �޸Ĺ�Ա����Ϣ
	Integer updateEmp(Employee emp);

	// ɾ���˹���Ա���еĽ�ɫ
	Integer delAdminRole(@Param("adminId") Integer adminId);

	// ɾ������Ա
	Integer delAdmin(@Param("adminIds") String[] ids);

	// ɾ����Ա
	Integer delEmp(@Param("empIds") String[] ids);

}
