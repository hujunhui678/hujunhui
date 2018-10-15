package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.FinishedProductsStock;
import cn.atc.util.PageUtil;

/**
 * 成品零件库存Service
 * @author ASUS
 *
 */
public interface FinishedProductsStockService {

	PageUtil<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // 获取成品零件库存信息
	
}
