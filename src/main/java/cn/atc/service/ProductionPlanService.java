package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.util.PageUtil;

public interface ProductionPlanService {
	PageUtil<ProductionPlan> getAllProPlan(Map<String, Object> maps);

	// ���������滮����ѯ���������������(���ͣ����࣬����)
	List<ProductionPlan> getPartFromulaById(@Param("id") String id);

	// ��ȡ�����ƻ�(���ڵ���excel)
	List<ProductionPlan> getProPlan(@Param("ProplanIds") String[] ids);

	// �������
	Integer ProductionPlanGoAudit(Map<String, Object> map);

	// ��ѯ��˲�ͨ��ԭ��
	ProductionPlan getReason(@Param("id") String id);

	Integer insertProplan(ProductionPlan pp);// ���������滮..

	Integer editProplan(ProductionPlan pp);// �޸������滮.
	// ��Ʒ�������ʱ�Զ����������ƻ�

	Integer addProductionPlan(Map<String, Object> map);
}
