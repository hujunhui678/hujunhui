package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsStock;

/**
 * ��Ʒ������Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsStockMapper {

	List<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // ��ȡ��Ʒ��������Ϣ
	
	Integer getFinishedProductsStocksCount();// ��ȡ��Ʒ��������������
	
	FinishedProductsStock getFinishedPartById(@Param("id")long id);// ����id��ȡ��Ʒ�����Ϣ
	
	Integer updateFinishedPartNum(Map<String, Object>map);// ����Ʒ��������
}
