package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.MaterialMapper;
import cn.atc.pojo.Material;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.service.MaterialService;
import cn.atc.util.PageUtil;

/**
 * Ã«Å÷¿â´æService
 * @author ASUS
 *
 */
@Service
public class MeterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper materialMapper;

	@Override
	public PageUtil<Material> getMaterialsByCondition(Map<String, Object> map) {
		Integer currentPageInteger= 1;
		String currentPage = (String)map.get("currentPage");
		if(currentPage==null||currentPage.equals("")) {
			currentPageInteger = 1;
		}else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		PageUtil<Material> page = new PageUtil<Material>();
		page.setTotalCount(materialMapper.getMaterialsCountByCondition(map));
		page.setPageSize(12);
		page.setCurrentPage(currentPageInteger);
		map.put("pageSize", page.getPageSize());
		map.put("startRow",page.getStartRow());
		map.put("currentPage", page.getCurrentPage());
		List<Material> materialList = materialMapper.getMaterialsByCondition(map);
		page.setLists(materialList);
		page.setTotalPage(page.getTotalPage());
		return page;
	}

	@Override
	public List<Material> getAllMaterials() {
		return materialMapper.getAllMaterials();
	}

	@Override
	public Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc) {
		return materialMapper.getOutMaterials(receiveCollectMaterialDesc);
	}
	
}
