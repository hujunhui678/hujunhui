package cn.atc.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ProductionPlanMapper;
import cn.atc.pojo.ProductionPlan;
import cn.atc.service.ProductionPlanService;
import cn.atc.util.PageUtil;

@Service
public class ProductionPlanServiceImp implements ProductionPlanService {
	@Autowired
	private ProductionPlanMapper productionPlanMapper;

	@Override
	public PageUtil<ProductionPlan> getAllProPlan(Map<String, Object> maps) {
		PageUtil<ProductionPlan> page = new PageUtil<ProductionPlan>();
		maps.put("pageSize", 6);
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(productionPlanMapper.count(maps));
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(productionPlanMapper.getAllProPlan(maps));
		return page;
	}

	@Override
	public List<ProductionPlan> getPartFromulaById(String id) {
		return productionPlanMapper.getPartFromulaById(id);
	}

	@Override
	public Integer ProductionPlanGoAudit(Map<String, Object> map) {
		return productionPlanMapper.ProductionPlanGoAudit(map);
	}

	@Override
	public ProductionPlan getReason(String id) {
		return productionPlanMapper.getReason(id);
	}

}
