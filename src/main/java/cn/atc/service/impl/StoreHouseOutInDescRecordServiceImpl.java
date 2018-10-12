package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import cn.atc.mapper.StoreHouseOutInDescRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.service.StoreHouseOutInDescRecordService;

@Service
public class StoreHouseOutInDescRecordServiceImpl implements StoreHouseOutInDescRecordService {

	@Autowired
	private StoreHouseOutInDescRecordMapper storeHouseOutInDescRecordMapper;
	
	@Override
	public List<StoreHouseOutInRecord> getStoreHouseOutInRecordById(Long recordId) {
		return storeHouseOutInDescRecordMapper.getStoreHouseOutInRecordById(recordId);
	}

	@Override
	public List<StoreHouseOutInRecord> getStoreHouseOutInRecordByMap(Map<String, Object> map) {
		return storeHouseOutInDescRecordMapper.getStoreHouseOutInRecordByMap(map);
	}

}
