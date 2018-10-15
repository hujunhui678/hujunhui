package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Orderform;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderDescMapper {
	// ���ݶ����Ż�ȡ������ϸ
	List<PurchaseOrderDesc> getPurchaseOrderDescByOrderId(@Param("orderId")Long orderId);
	
	Integer add(PurchaseOrderDesc purchaseOrderDesc);
	
}