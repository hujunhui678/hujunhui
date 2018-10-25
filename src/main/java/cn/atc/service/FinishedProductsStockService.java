package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsStock;
import cn.atc.util.PageUtil;

/**
 * ��Ʒ������Service
 * @author ASUS
 *
 */
public interface FinishedProductsStockService {

	PageUtil<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map); // ��ȡ��Ʒ��������Ϣ

	FinishedProductsStock getFinishedPartById(@Param("id")long id);// ����ID��ȡ��Ʒ������
	
	Integer updateFinishedPartNum(Map<String, Object>map);// ����Ʒ��������
}
