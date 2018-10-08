package cn.atc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PartFormulaMapper;
import cn.atc.pojo.PartFormula;
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

}
