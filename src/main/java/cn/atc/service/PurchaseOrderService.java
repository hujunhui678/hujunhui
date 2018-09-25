package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrder;

public interface PurchaseOrderService {
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map);
}
