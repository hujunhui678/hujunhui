package cn.atc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ReceiveCollectMaterialDescMapper;
import cn.atc.mapper.ReceiveCollectMaterialMapper;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.service.ReceiveCollectMaterialService;
import cn.atc.util.PageUtil;

/**
 * 收领料单service
 * @author ASUS
 *
 */
@Service
public class ReceiveCollectMaterialServiceImpl implements ReceiveCollectMaterialService{

	@Autowired
	private ReceiveCollectMaterialMapper receiveCollectMaterialMapper;
	@Autowired
	private ReceiveCollectMaterialDescMapper receiveCollectMaterialDescMapper;
	
	@Override
	public PageUtil<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map) {
		String auditStateId = (String)map.get("auditStateId");
		String materialId = (String)map.get("materialId");
		String releaseTime = (String)map.get("releaseTime");
		if(auditStateId==null) {
			map.put("auditStateId",0);
		}
		if(materialId==null) {
			map.put("materialId",0);
		}
		if(releaseTime==null) {
			map.put("releaseTime","");
		}
		PageUtil<ReceiveCollectMaterial> page = new PageUtil<ReceiveCollectMaterial>();
		Integer count = receiveCollectMaterialMapper.getReceiveCollectMaterialCountByCondition(map);
		String currentPage = (String)map.get("currentPage");
		Integer currentPageInteger = 0;
		if(currentPage==null || currentPage.equals("")) {
			currentPageInteger = 1;
		}else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		page.setTotalCount(count);
		page.setPageSize(6);
		page.setCurrentPage(currentPageInteger);
		map.put("pageSize", page.getPageSize());
		map.put("startRow",page.getStartRow());
		map.put("currentPage", page.getCurrentPage());
		List<ReceiveCollectMaterial> receiveCollectMaterialList = receiveCollectMaterialMapper.getReceiveCollectMaterialByCondition(map);
		page.setTotalPage(page.getTotalPage());
		page.setLists(receiveCollectMaterialList);
		return page;
	}

	@Override
	public Integer updateIsAgreeById(Map<String, Object> map) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("agreeTime", sdf.format(new Date()));
		return receiveCollectMaterialMapper.updateIsAgreeById(map);
	}

	@Override
	public Integer insertReceive(ReceiveCollectMaterial rcm) {
		return receiveCollectMaterialMapper.insertReceive(rcm);
	}

	@Override
	public Integer auditReceive(ReceiveCollectMaterial rcm) {
		return receiveCollectMaterialMapper.auditReceive(rcm);
	}

	@Override
	public ReceiveCollectMaterial getReason(String id) {
		return receiveCollectMaterialMapper.getReason(id);
	}

	@Override
	public Integer delReveive(String id) {
		Integer re = receiveCollectMaterialDescMapper.delReveiveDesc(id);
		return receiveCollectMaterialMapper.delReveive(id);
	}

	@Override
	public Integer updateIsAgreeByIdH(Map<String, Object> map) {
		return receiveCollectMaterialMapper.updateIsAgreeByIdH(map);
	}

}
