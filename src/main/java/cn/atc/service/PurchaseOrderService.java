package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.PurchaseOrder;
import cn.atc.util.PageUtil;

public interface PurchaseOrderService {
	// ����������ȡ������Ϣ
	PageUtil<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map);

	// �޸Ķ���ǩ��״̬
	Integer updateIsSigninById(Map<String, Object>map);
	
	Integer add(PurchaseOrder purchaseOrder);
}
