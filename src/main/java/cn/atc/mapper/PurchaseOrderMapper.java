package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	// 获取采购订单信息
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
}
