package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.StoreHouseOutInRecord;

/**
 * 出库入库记录Mapper
 * @author ASUS
 *
 */
public interface StoreHouseOutInRecordMapper {
	
	List<StoreHouseOutInRecord> getStoreHouseOutInRecordByCondition(Map<String, Object>map);
	Integer getStoreHouseOutInRecordCountByCondition(Map<String, Object>map);
	Integer insertStoreHouseOutInRecord(Map<String, Object>map);// 生成出库记录
	Integer insertStoreHouseOutInDescRecord(Map<String, Object>map);// 生成出库详细记录
}
