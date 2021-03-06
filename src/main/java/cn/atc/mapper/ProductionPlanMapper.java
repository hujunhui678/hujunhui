package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.Productivetask2;

public interface ProductionPlanMapper {
	List<ProductionPlan> getAllProPlan(Map<String, Object> maps);// 获得所有的技术规划

	Integer count(Map<String, Object> maps);// 获得数量

	// 根据生产规划，查询出具体生产的零件(类型，分类，数量)
	List<ProductionPlan> getPartFromulaById(@Param("id") String id);

	// 获取生产计划(用于导出excel)
	List<ProductionPlan> getProPlan(@Param("ProplanIds") String[] ids);

	// 进行审核
	Integer ProductionPlanGoAudit(Map<String, Object> map);

	// 查询审核不通过原因
	ProductionPlan getReason(@Param("id") String id);

	Integer insertProplan(ProductionPlan pp);// 新增生产规划..

	Integer editProplan(ProductionPlan pp);// 修改生产规划.
	// 查询审核不通过原因

	// 成品零件不足时自动生成生产计划
	Integer addProductionPlan(Map<String, Object> map);
	
	List<ProductionPlan>queryAll();


	Integer getProductivetasktCount();

	Integer addProductivetask(Productivetask2 productivetask);

	Integer updateProductivetask(Productivetask2 productivetask);

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷删锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param id
	 * @return
	 */
	Integer deleteProductivetask(String id);
}
