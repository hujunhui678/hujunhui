package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.FinishedProductsStock;

/**
 * 成品零件库存Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsStockMapper {

	List<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // 获取成品零件库存信息
	
	Integer getFinishedProductsStocksCount();// 获取成品零件库存数据条数
}
