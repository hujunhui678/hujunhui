package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderDescService {
	// ���ݶ����Ż�ȡ������ϸ
	List<PurchaseOrderDesc> getPurchaseOrderDescByOrderId(Long orderId);
	Integer add(PurchaseOrderDesc purchaseOrderDesc);
}
