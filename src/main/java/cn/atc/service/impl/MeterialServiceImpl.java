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
 * ë�����Service
 * 
 * @author ASUS
 *
 */
@Service
public class MeterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper meterialMapper;

	@Override
	public PageUtil<Material> getMaterialsByCondition(Map<String, Object> map) {
		Integer currentPageInteger = 1;
		String currentPage = (String) map.get("currentPage");
		if (currentPage == null || currentPage.equals("")) {
			currentPageInteger = 1;
		} else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		PageUtil<Material> page = new PageUtil<Material>();
		page.setTotalCount(meterialMapper.getMaterialsCountByCondition(map));
		page.setPageSize(12);
		page.setCurrentPage(currentPageInteger);
		map.put("pageSize", page.getPageSize());
		map.put("startRow", page.getStartRow());
		map.put("currentPage", page.getCurrentPage());
		List<Material> materialList = meterialMapper.getMaterialsByCondition(map);
		page.setLists(materialList);
		page.setTotalPage(page.getTotalPage());
		return page;
	}

	@Override
	public Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc) {
		return meterialMapper.getOutMaterials(receiveCollectMaterialDesc);
	}

	@Override
	public List<Material> getAllMaterials() {
		return meterialMapper.getAllMaterials();
	}

	@Override
	public Integer insertMater(Integer id) {
		return meterialMapper.insertMater(id);
	}

	public Integer getInFinishedProductsStock(ReceiveCollectMaterialDesc receiveCollectMaterialDesc) {
		return meterialMapper.getInFinishedProductsStock(receiveCollectMaterialDesc);
	}

	@Override
	public int update(Material material) {
		// TODO Auto-generated method stub
		return meterialMapper.update(material);
	}
}
