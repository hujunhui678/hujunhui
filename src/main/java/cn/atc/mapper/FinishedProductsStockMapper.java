package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsStock;

/**
 * 成品零件库存Mapper
 * @author ASUS
 *
 */
public interface FinishedProductsStockMapper {

	List<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // 获取成品零件库存信息
	
	Integer getFinishedProductsStocksCount();// 获取成品零件库存数据条数
	
	FinishedProductsStock getFinishedPartById(@Param("id")long id);// 根据id获取成品库存信息
	
	Integer updateFinishedPartNum(Map<String, Object>map);// 库存成品数量增加
}
