package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PartTypeMapper;
import cn.atc.pojo.PartType;
import cn.atc.service.PartTypeService;

@Service
public class PartTypeServiceImp implements PartTypeService {

	@Autowired
	private PartTypeMapper partTypeMapper;

	@Override
	public List<PartType> getAllType() {
		return partTypeMapper.getAllType();
	}

}
