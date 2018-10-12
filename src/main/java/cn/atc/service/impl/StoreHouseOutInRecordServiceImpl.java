package cn.atc.service.impl;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.StoreHouseOutInRecordMapper;
import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.service.StoreHouseOutInRecordService;
import cn.atc.util.PageUtil;

/**
 * ³ö¿âÈë¿â¼ÇÂ¼Service
 * @author ASUS
 *
 */
@Service
public class StoreHouseOutInRecordServiceImpl implements StoreHouseOutInRecordService {

	@Autowired
	private StoreHouseOutInRecordMapper storeHouseOutInRecordServiceMapper;
	
	@Override
	public PageUtil<StoreHouseOutInRecord> getStoreHouseOutInRecordByCondition(Map<String, Object> map) {
		PageUtil<StoreHouseOutInRecord> page = new PageUtil<StoreHouseOutInRecord>();
		String currentPage = (String)map.get("currentPage");
		Integer currentPageInteger = 0;
		if(currentPage==null || currentPage.equals("")) {
			currentPageInteger = 1;
		}else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		page.setTotalCount(storeHouseOutInRecordServiceMapper.getStoreHouseOutInRecordCountByCondition(map));
		page.setPageSize(10);
		page.setCurrentPage(currentPageInteger);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		map.put("startRow",page.getStartRow());
		List<StoreHouseOutInRecord> storeHouseOutInRecordList = storeHouseOutInRecordServiceMapper.getStoreHouseOutInRecordByCondition(map);
		for (StoreHouseOutInRecord storeHouseOutInRecord : storeHouseOutInRecordList) {
			storeHouseOutInRecord.setTime(storeHouseOutInRecord.getTime().substring(0,16));
		}
		page.setLists(storeHouseOutInRecordList);
		page.setTotalPage(page.getTotalPage());
		return page;
	}

	@Override
	public boolean insertStoreHouseOutInRecord(Map<String, Object> storeHouseOutInRecord,
			List<Map<String, Object>> storeHouseOutInDescRecordList) {
		boolean sign = false;
		if(storeHouseOutInRecordServiceMapper.insertStoreHouseOutInRecord(storeHouseOutInRecord)>=0) {
			for (Map<String, Object> map : storeHouseOutInDescRecordList) {
				if(storeHouseOutInRecordServiceMapper.insertStoreHouseOutInDescRecord(map)<=0) {
					return false;
				}
			}
			sign = true;
		}
		return sign;
	}

	@Override
	public Integer getIsOutCount() {
		return storeHouseOutInRecordServiceMapper.getIsOutCount();
	}

	@Override
	public Integer getIsInCount() {
		return storeHouseOutInRecordServiceMapper.getIsInCount();
	}

}
