package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.Productivetask2;

public interface ProductionPlanMapper {
	List<ProductionPlan> getAllProPlan(Map<String, Object> maps);// ������еļ����滮

	Integer count(Map<String, Object> maps);// �������

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
	// ��ѯ��˲�ͨ��ԭ��

	// ��Ʒ�������ʱ�Զ����������ƻ�
	Integer addProductionPlan(Map<String, Object> map);
	
	List<ProductionPlan>queryAll();


	Integer getProductivetasktCount();

	Integer addProductivetask(Productivetask2 productivetask);

	Integer updateProductivetask(Productivetask2 productivetask);

	/**
	 * ��������ɾ������������
	 * @param id
	 * @return
	 */
	Integer deleteProductivetask(String id);
}
