package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.FinishedProductsStock;

/**
 * ��Ʒ������Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsStockMapper {

	List<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // ��ȡ��Ʒ��������Ϣ
	
	Integer getFinishedProductsStocksCount();// ��ȡ��Ʒ��������������
}
