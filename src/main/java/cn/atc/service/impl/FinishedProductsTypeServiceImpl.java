package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.FinishedProductsTypeMapper;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.service.FinishedProductsTypeService;

/**
 * 成品类别Service
 * @author ASUS
 *
 */
@Service
public class FinishedProductsTypeServiceImpl implements FinishedProductsTypeService {

	@Autowired
	private FinishedProductsTypeMapper finishedProductsTypeMapper;
	
	@Override
	public Integer insertFinishedProductsType(FinishedProductsType finishedProductsType) {
		return finishedProductsTypeMapper.insertFinishedProductsType(finishedProductsType);
	}
	
	public List<FinishedProductsType> getFinishedproductstype() {
		return finishedProductsTypeMapper.getFinishedproductstype();
	}

}
