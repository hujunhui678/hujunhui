package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	// ��ȡ�ɹ�������Ϣ
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
}
