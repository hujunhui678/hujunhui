package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.util.PageUtil;

public interface StoreHouseOutInRecordService {
	PageUtil<StoreHouseOutInRecord> getStoreHouseOutInRecordByCondition(Map<String, Object>map);
	// ���ɳ���&����¼����ϸ������
	boolean insertStoreHouseOutInRecord(Map<String, Object> storeHouseOutInRecord,List<Map<String, Object>> storeHouseOutInDescRecordList);
	Integer getIsOutCount();// ��ȡ�����¼��
	Integer getIsInCount();// ��ȡ����¼��
	int add(StoreHouseOutInRecord storeHouseOutInRecord);
}
