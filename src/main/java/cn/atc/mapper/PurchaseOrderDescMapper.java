package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderDescMapper {
	// 根据订单号获取订单详细
	List<PurchaseOrderDesc> getPurchaseOrderDescByOrderId(@Param("orderId")Long orderId);
	// 添加采购单详细数据
	Integer insertPurchaseOrderDesc(Map<String, Object>map);
}
