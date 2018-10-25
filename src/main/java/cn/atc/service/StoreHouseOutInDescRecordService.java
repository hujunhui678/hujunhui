package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.StoreHouseOutInDescRecord;
import cn.atc.pojo.StoreHouseOutInRecord;

public interface StoreHouseOutInDescRecordService {
	List<StoreHouseOutInRecord> getStoreHouseOutInRecordById(@Param("recordId")Long recordId);// 根据id获取记录详情信息
	List<StoreHouseOutInRecord>  getStoreHouseOutInRecordByMap(Map<String, Object>map);// 根据条件获取零件出入库记录
	
	public int add(StoreHouseOutInDescRecord storeHouseOutInDescRecord);
}
