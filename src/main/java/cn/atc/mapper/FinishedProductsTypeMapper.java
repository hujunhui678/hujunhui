package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.FinishedProductsType;

/**
 * ��Ʒ���Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsTypeMapper {

	Integer insertFinishedProductsType(FinishedProductsType finishedProductsType);// ��ӳ�Ʒ���
	List<FinishedProductsType> getFinishedproductstype();
}
