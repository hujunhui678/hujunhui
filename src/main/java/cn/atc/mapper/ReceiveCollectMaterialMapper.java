package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * �����ϵ�mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialMapper {
	List<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// ����������ȡ�����ϵ�
	Integer getReceiveCollectMaterialCountByCondition(Map<String, Object>map);// ����������ȡ�����ϵ�����
	Integer updateIsAgreeById(Map<String, Object> map);// ����ͨ�� �޸�״̬
	Integer updateIsAgreeByIdH(Map<String, Object> map);// ����ͨ�� �޸�״̬
	
	Integer insertReceive(ReceiveCollectMaterial rcm);//�������ϵ�
	
	Integer auditReceive(ReceiveCollectMaterial rcm);//������ϵ�
	
	//��ѯ��˲�ͨ��ԭ��
	ReceiveCollectMaterial getReason(@Param("id")String id);
	
	Integer delReveive(@Param("id")String id);
}
