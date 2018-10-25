package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsStock;
import cn.atc.util.PageUtil;

/**
 * 成品零件库存Service
 * @author ASUS
 *
 */
public interface FinishedProductsStockService {

	PageUtil<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // 获取成品零件库存信息

	FinishedProductsStock getFinishedPartById(@Param("id")long id);// 根据ID获取成品零件库存
	
	Integer updateFinishedPartNum(Map<String, Object>map);// 库存成品数量增加
}
