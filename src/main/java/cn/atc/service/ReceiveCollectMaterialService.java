package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.util.PageUtil;

public interface ReceiveCollectMaterialService {
	PageUtil<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// ����������ȡ�����ϵ�

	Integer updateIsAgreeById(Map<String, Object> map);// ����ͨ�� �޸�״̬

	Integer insertReceive(ReceiveCollectMaterial rcm);// �������ϵ�

	Integer auditReceive(ReceiveCollectMaterial rcm);// ������ϵ�

	//��ѯ��˲�ͨ��ԭ��
	ReceiveCollectMaterial getReason(@Param("id")String id);
	
	//ɾ�����ϵ����Ƚ���ɾ���������鵥
	Integer delReveive(@Param("id")String id);
}
