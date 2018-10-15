package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PartTypeMapper;
import cn.atc.pojo.PartType;
import cn.atc.service.PartTypeService;

@Service
public class PartTypeServiceImpl implements PartTypeService {

	@Autowired
	private PartTypeMapper partTypeMapper;
	
	@Override
	public List<PartType> getPartTypes() {
		return partTypeMapper.getPartTypes();
	}

	@Override
	public Integer insertPartType(PartType partType) {
		return partTypeMapper.insertPartType(partType);
	}
	
	@Override
	public List<PartType> getAllType() {
		return partTypeMapper.getAllType();
	}

}
