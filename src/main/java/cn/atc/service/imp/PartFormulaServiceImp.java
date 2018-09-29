package cn.atc.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PartFormulaMapper;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.PartFormulaDesc;
import cn.atc.pojo.PartType;
import cn.atc.service.PartFormulaService;
import cn.atc.util.PageUtil;

@Service
public class PartFormulaServiceImp implements PartFormulaService {

	@Autowired
	private PartFormulaMapper partFormulaMapper;

	@Override
	public PageUtil<PartFormula> getAllPartFrom(Map<String, Object> maps) {
		PageUtil<PartFormula> page = new PageUtil<PartFormula>();
		maps.put("pageSize", 3);
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(partFormulaMapper.count(maps));
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(partFormulaMapper.getAllPartFrom(maps));
		return page;
	}

	@Override
	public List<FinishedProductsType> getAllFinish() {
		return partFormulaMapper.getAllFinish();
	}

	@Override
	public Integer addPartType(PartType partType) {
		return partFormulaMapper.addPartType(partType);
	}

	@Override
	public PartType getPartType(Integer id) {
		return partFormulaMapper.getPartType(id);
	}

	@Override
	public Integer addPartFormula(PartFormula partFormula) {
		return partFormulaMapper.addPartFormula(partFormula);
	}

	@Override
	public Integer addPartFormulaDesc(PartFormulaDesc partFormulaDesc) {
		return partFormulaMapper.addPartFormulaDesc(partFormulaDesc);
	}

}
