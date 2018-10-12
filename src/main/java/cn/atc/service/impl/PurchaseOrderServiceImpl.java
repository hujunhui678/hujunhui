package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PurchaseOrderMapper;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.service.PurchaseOrderService;
import cn.atc.util.PageUtil;

/**
 * ²É¹º¶©µ¥Service
 * @author ASUS
 *
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderMapper purchaseOrderMapper;
	
	@Override
	public PageUtil<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map) {
		String auditStateId = (String)map.get("auditStateId");
		String purchaseOrderId = (String)map.get("purchaseOrderId");
		String purchaseTime = (String)map.get("purchaseTime");
		String partType = (String)map.get("partType");
		if(auditStateId==null) {
			map.put("auditStateId",0);
		}
		if(purchaseOrderId==null) {
			map.put("purchaseOrderId",0);
		}
		if(purchaseTime==null) {
			map.put("purchaseTime","");
		}
		if(partType==null) {
			map.put("partType",0);
		}
		PageUtil<PurchaseOrder> page = new PageUtil<PurchaseOrder>();
		Integer count = purchaseOrderMapper.getPurchaseOrderCountByCondition(map);
		String currentPage = (String)map.get("currentPage");
		Integer currentPageInteger = 0;
		if(currentPage==null || currentPage.equals("")) {
			currentPageInteger = 1;
		}else {
			currentPageInteger = Integer.parseInt(currentPage);
		}
		page.setTotalCount(count);
		page.setPageSize(10);
		page.setCurrentPage(currentPageInteger);
		map.put("pageSize", page.getPageSize());
		map.put("startRow",page.getStartRow());
		map.put("currentPage", page.getCurrentPage());
		List<PurchaseOrder> purchaseOrderList = purchaseOrderMapper.getPurchaseOrdersByCondition(map);
		page.setLists(purchaseOrderList);
		return page;
	}

	@Override
	public Integer updateIsSigninById(Map<String, Object>map) {
		return purchaseOrderMapper.updateIsSigninById(map);
	}

	@Override
	public Integer insertPurchaseOrder(Map<String, Object> map) {
		return purchaseOrderMapper.insertPurchaseOrder(map);
	}
}
