package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;

public interface ProductionPlanMapper {
	List<ProductionPlan> getAllProPlan(Map<String, Object> maps);//获得所有的技术规划
	Integer count(Map<String, Object> maps);//获得数量
	
	//根据生产规划，查询出具体生产的零件(类型，分类，数量)
	List<ProductionPlan> getPartFromulaById(@Param("id")String id);
	
	//进行审核
	Integer ProductionPlanGoAudit(Map<String, Object> map);
	
	//查询审核不通过原因
	ProductionPlan getReason(@Param("id")String id);
}
