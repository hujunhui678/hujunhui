package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PurchaseOrderDescMapper;
import cn.atc.mapper.PurchaseOrderMapper;
import cn.atc.pojo.PurchaseOrderDesc;
import cn.atc.service.PurchaseOrderDescService;

/**
 * ∂©µ•œÍ«Èservice
 * @author ASUS
 *
 */
@Service
public class PurchaseOrderDescServiceImpl implements PurchaseOrderDescService{

	@Autowired
	private PurchaseOrderDescMapper purchaseOrderDescMapper;
	
	@Override
	public List<PurchaseOrderDesc> getPurchaseOrderDescByOrderId(Long orderId) {
		return purchaseOrderDescMapper.getPurchaseOrderDescByOrderId(orderId);
	}

	@Override
	public Integer insertPurchaseOrderDesc(Map<String, Object> map) {
		return purchaseOrderDescMapper.insertPurchaseOrderDesc(map);
	}

}
