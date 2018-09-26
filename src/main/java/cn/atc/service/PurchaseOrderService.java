package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.PurchaseOrder;
import cn.atc.util.PageUtil;

public interface PurchaseOrderService {
	PageUtil<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map);
}
