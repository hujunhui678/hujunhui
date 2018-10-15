package cn.atc.service;

import java.util.List;

import cn.atc.pojo.FinishedProductsType;

public interface FinishedProductsTypeService {

	Integer insertFinishedProductsType(FinishedProductsType finishedProductsType);// 添加成品类别
	List<FinishedProductsType> getFinishedproductstype();
}
