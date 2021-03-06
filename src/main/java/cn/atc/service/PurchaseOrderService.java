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
	// 发布订单
	Integer insertPurchaseOrder(Map<String, Object>map);

	// 审核订单
	Integer updateAuditStateId(Map<String, Object>map);
	
	// 未通过备注
	Integer updateNotPassDesc(Map<String, Object>map);
}
