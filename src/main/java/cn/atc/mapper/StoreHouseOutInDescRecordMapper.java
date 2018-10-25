package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.StoreHouseOutInDescRecord;
import cn.atc.pojo.StoreHouseOutInRecord;

public interface StoreHouseOutInDescRecordMapper {
	List<StoreHouseOutInRecord> getStoreHouseOutInRecordById(@Param("recordId")Long recordId);// ����id��ȡ��¼������Ϣ
	List<StoreHouseOutInRecord>  getStoreHouseOutInRecordByMap(Map<String, Object>map);// ����������ȡ���������¼
	
	public int add(StoreHouseOutInDescRecord storeHouseOutInDescRecord);
}
