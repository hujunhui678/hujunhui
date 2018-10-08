package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.FinishedProductsStockMapper;
import cn.atc.pojo.FinishedProductsStock;
import cn.atc.service.FinishedProductsStockService;
import cn.atc.util.PageUtil;

@Service
public class FinishedProductsStockServiceImpl implements FinishedProductsStockService {

	@Autowired
	private FinishedProductsStockMapper finishedProductsStockMapper;
	
	@Override
	public PageUtil<FinishedProductsStock> getFinishedProductsStocks(Map<String, Object>map) {
		PageUtil<FinishedProductsStock> page = new PageUtil<FinishedProductsStock>();
		Integer currentPageInteger= 1;
		String currentPage = (String)map.get("currentPage");
		if(currentPage==null||currentPage.equals("")) {
			currentPageInteger = 1;
		}else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		page.setTotalCount(finishedProductsStockMapper.getFinishedProductsStocksCount());
		page.setPageSize(12);
		page.setCurrentPage(currentPageInteger);
		map.put("pageSize", page.getPageSize());
		map.put("startRow",page.getStartRow());
		map.put("currentPage", page.getCurrentPage());
		List<FinishedProductsStock> finishedProductsStocks = finishedProductsStockMapper.getFinishedProductsStocks(map);
		page.setLists(finishedProductsStocks);
		page.setTotalPage(page.getTotalPage());
		return page;
	}
}
