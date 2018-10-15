package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.util.PageUtil;

public interface ProductionPlanService {
	PageUtil<ProductionPlan> getAllProPlan(Map<String, Object> maps);
	//根据生产规划，查询出具体生产的零件(类型，分类，数量)
	List<ProductionPlan> getPartFromulaById(@Param("id")String id);
	//进行审核
	Integer ProductionPlanGoAudit(Map<String, Object> map);
	//查询审核不通过原因
	ProductionPlan getReason(@Param("id")String id);
}
