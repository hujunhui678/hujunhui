package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;

public interface PurchaseOrderMapper {
	// ��ȡ�ɹ�������Ϣ
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
	
	// ��ȡ�ɹ�������Ϣ����
	Integer getPurchaseOrderCountByCondition(Map<String, Object> map);
}
