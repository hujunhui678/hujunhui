package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * �����ϵ�mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialMapper {
	List<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// ����������ȡ�����ϵ�
	Integer getReceiveCollectMaterialCountByCondition(Map<String, Object>map);// ����������ȡ�����ϵ�����
	Integer updateIsAgreeById(Map<String, Object>map);// ����ͨ�� �޸�״̬
}
