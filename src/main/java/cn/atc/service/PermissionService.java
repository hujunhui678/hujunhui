package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.common.AllPerm;
import cn.atc.pojo.Permission;

public interface PermissionService {

	/**
	 * ��ȡȨ����Ϣ(���е�Ȩ��)
	 * @return һ��Ȩ�޼���
	 */
	List<AllPerm> getPerm();
	
	/**
	 * ��ȡȨ����Ϣ(���ݽ�ɫId��ȡȨ��)
	 * @return һ��Ȩ�޼���
	 */
	List<AllPerm> getPermByRoleId(long id);
	
	/**
	 * ����������ȡ1J��2J����Ȩ�ޣ�ת����Permission�෵��
	 * @param permLevel Ȩ�޹���ҳ��ѡ���Ȩ�޵ȼ�
	 * @param parentPermId ����Ȩ��ID������������
	 * @return
	 */
	List<Permission> getAllPermConverterPerm(Integer permLevel);
	
	// ���Ȩ��
	boolean insertPerm(Permission permission);
	
	// ��ӽ�ɫȨ�����ӱ�����
	boolean insertRolePermByRoleIdAndPermId(Map<String, Object> map);
}
