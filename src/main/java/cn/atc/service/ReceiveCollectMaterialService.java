package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.util.PageUtil;

public interface ReceiveCollectMaterialService {
	PageUtil<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);//����������ȡ�����ϵ�
	Integer updateIsAgreeById(Map<String, Object>map);// ����ͨ�� �޸�״̬
}
