package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderMapper {
	// 获取采购订单信息
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
	
	// 获取采购订单信息数量
	Integer getPurchaseOrderCountByCondition(Map<String, Object> map);
}
