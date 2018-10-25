package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.util.PageUtil;

public interface StoreHouseOutInRecordService {
	PageUtil<StoreHouseOutInRecord> getStoreHouseOutInRecordByCondition(Map<String, Object>map);
	// 生成出库&入库记录及详细表数据
	boolean insertStoreHouseOutInRecord(Map<String, Object> storeHouseOutInRecord,List<Map<String, Object>> storeHouseOutInDescRecordList);
	Integer getIsOutCount();// 获取出库记录数
	Integer getIsInCount();// 获取入库记录数
	int add(StoreHouseOutInRecord storeHouseOutInRecord);
}
