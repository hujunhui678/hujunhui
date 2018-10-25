package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	// ��ȡ�ɹ�������Ϣ
	List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object>map);
	
	// ��ȡ�ɹ�������Ϣ����
	Integer getPurchaseOrderCountByCondition(Map<String, Object> map);
	
	// �޸Ķ���ǩ��״̬
	Integer updateIsSigninById(Map<String, Object> map);
	
	Integer add(PurchaseOrder purchaseOrder);
	// ��������
	Integer insertPurchaseOrder(Map<String, Object>map);
	
	// ��˶���
	Integer updateAuditStateId(Map<String, Object>map);
	
	// δͨ����ע
	Integer updateNotPassDesc(Map<String, Object>map);
}
