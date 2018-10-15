package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.FinishedProductsTypeMapper;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.service.FinishedProductsTypeService;

@Service
public class FinishedProductsTypeServiceImpl implements FinishedProductsTypeService {
			@Autowired
			private FinishedProductsTypeMapper mapper;
	@Override
	public List<FinishedProductsType> getFinishedproductstype() {
			
		return mapper.getFinishedproductstype();
	}

}
