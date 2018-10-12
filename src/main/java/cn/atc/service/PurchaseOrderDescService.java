package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderDescService {
	// 根据订单号获取订单详细
	List<PurchaseOrderDesc> getPurchaseOrderDescByOrderId(Long orderId);
	// 添加采购单详细数据
	Integer insertPurchaseOrderDesc(Map<String, Object>map);
}
