package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.PurchaseOrder;
import cn.atc.util.PageUtil;

public interface PurchaseOrderService {
	// 根据条件获取订单信息
	PageUtil<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map);

	// 修改订单签收状态
	Integer updateIsSigninById(Map<String, Object>map);
	
	Integer add(PurchaseOrder purchaseOrder);
}
