package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.FinishedProductsStock;
import cn.atc.util.PageUtil;

/**
 * ��Ʒ������Service
 * @author ASUS
 *
 */
public interface FinishedProductsStockService {

	PageUtil<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // ��ȡ��Ʒ��������Ϣ
	
}
