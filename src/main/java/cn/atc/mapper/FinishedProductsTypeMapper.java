package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.FinishedProductsType;

/**
 * 成品类别Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsTypeMapper {

	Integer insertFinishedProductsType(FinishedProductsType finishedProductsType);// 添加成品类别
	List<FinishedProductsType> getFinishedproductstype();
}
