package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	// 获取采购订单信息
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
	
	// 获取采购订单信息数量
	Integer getPurchaseOrderCountByCondition(Map<String, Object> map);
	
	// 修改订单签收状态
	Integer updateIsSigninById(Map<String, Object> map);
	
	// 发布订单
	Integer insertPurchaseOrder(Map<String, Object>map);
}
