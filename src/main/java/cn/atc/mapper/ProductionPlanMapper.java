package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;

public interface ProductionPlanMapper {
	List<ProductionPlan> getAllProPlan(Map<String, Object> maps);//������еļ����滮
	Integer count(Map<String, Object> maps);//�������
	
	//���������滮����ѯ���������������(���ͣ����࣬����)
	List<ProductionPlan> getPartFromulaById(@Param("id")String id);
	
	//�������
	Integer ProductionPlanGoAudit(Map<String, Object> map);
	
	//��ѯ��˲�ͨ��ԭ��
	ProductionPlan getReason(@Param("id")String id);
}
