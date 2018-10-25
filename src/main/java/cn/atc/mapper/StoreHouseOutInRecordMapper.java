package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.StoreHouseOutInRecord;

/**
 * ��������¼Mapper
 * @author ASUS
 *
 */
public interface StoreHouseOutInRecordMapper {
	
	List<StoreHouseOutInRecord> getStoreHouseOutInRecordByCondition(Map<String, Object>map);
	Integer getStoreHouseOutInRecordCountByCondition(Map<String, Object>map);
	Integer insertStoreHouseOutInRecord(Map<String, Object>map);// ���ɳ����¼
	Integer insertStoreHouseOutInDescRecord(Map<String, Object>map);// ���ɳ�����ϸ��¼
	Integer getIsOutCount();// ��ȡ�����¼��
	Integer getIsInCount();// ��ȡ����¼��
}
