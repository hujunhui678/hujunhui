package cn.atc.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PurchaseOrderMapper;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.service.PurchaseOrderService;

/**
 * ²É¹º¶©µ¥Service
 * @author ASUS
 *
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderMapper purchaseOrderMapper;
	
	@Override
	public List<PurchaseOrder> getPurchaseOrdersByCondition(Map<String, Object> map) {
		return purchaseOrderMapper.getPurchaseOrdersByCondition(map);
	}

}
