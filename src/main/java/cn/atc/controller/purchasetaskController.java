package cn.atc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.mapper.StoreHouseOutInDescRecordMapper;
import cn.atc.pojo.AuditState;
import cn.atc.pojo.Material;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;
import cn.atc.pojo.StoreHouseOutInDescRecord;
import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.service.AuditStateService;
import cn.atc.service.MaterialService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PurchaseOrderDescService;
import cn.atc.service.PurchaseOrderService;
import cn.atc.service.StoreHouseOutInDescRecordService;
import cn.atc.service.StoreHouseOutInRecordService;
import cn.atc.service.impl.PurchaseOrderDescServiceImpl;
import cn.atc.service.impl.PurchaseOrderServiceImpl;
import cn.atc.util.GsonUtil;
import cn.atc.util.IDUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class purchasetaskController {
	// ajax获取采购订单详情信息并使用json返回
	@Autowired
		PurchaseOrderDescService purchaseOrderDescService;
	@Autowired
		PurchaseOrderService purchaseOrderService;
	@Autowired
	PartClassifyService partClassifyService;
	@Autowired
	AuditStateService auditStateService;
	@Autowired		
	StoreHouseOutInDescRecordService storeHouseOutInDescRecord;
	@Autowired	
	StoreHouseOutInRecordService storeHouseOutInRecord;
	@Autowired
	MaterialService material;
	@RequestMapping("/getPurchaseOrderDesc")
	@ResponseBody
	public String getPurchaseOrderDesc(Long orderId) {
		List<PurchaseOrderDesc> orders = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		String orderList = GsonUtil.GsonString(orders);
		return orderList;
	}

	// 修改订单签收状态
	@RequestMapping("/updateIsSigninById")
	@ResponseBody
	public String updateIsSigninById(Long id, Long adminId, Map<String, Object> map) {
		
		map.put("id", id);
		map.put("adminId", adminId);
	StoreHouseOutInRecord ss=new StoreHouseOutInRecord();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ss.setTime(sdf.format(new Date()));
		IDUtil s=new IDUtil();		
		ss.setId(((Long)s.getId()).toString());
		int addOutInresult = storeHouseOutInRecord.add(ss);
		if(addOutInresult==0) {
			return "no";
		}
		//取零件信息
		List<PurchaseOrderDesc> purchaseOrderDesc = purchaseOrderDescService.getPurchaseOrderDescByOrderId(id);
		for (PurchaseOrderDesc purchase : purchaseOrderDesc) {
			StoreHouseOutInDescRecord aa=new StoreHouseOutInDescRecord();
			aa.setOutInRecordId(ss.getId());
			aa.setPartTypeId(purchase.getPartType().getId());
			aa.setNum(purchase.getOrderNum());
			storeHouseOutInDescRecord.add(aa);
			Material mm = new Material();
			mm.setMatType(purchase.getPartType().getId());
			mm.setInventoryNum(purchase.getOrderNum());
			material.update(mm);
		}
		Integer result = purchaseOrderService.updateIsSigninById(map);
		if (result > 0) {
			return "yes";
		} else {
			return "no";
		}
	}

	// 跳转到采购任务单页
	@RequestMapping(value = "/purchasetask")
	public String purchasetask(Model model, Map<String, Object> map, String partType, String auditStateId,
			String purchaseOrderId, String purchaseTime, String currentPage, String totalPage) {
		if (purchaseOrderId != null) {
			if (purchaseOrderId.contains("ATC")) {
				purchaseOrderId = purchaseOrderId.substring(3);
			}
		}
		map.put("auditStateId", auditStateId);
		map.put("purchaseOrderId", purchaseOrderId);
		map.put("purchaseTime", purchaseTime);
		map.put("partType", partType);
		map.put("currentPage", currentPage);
		// 获取所有零件类别
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// 获取采购订单表基础数据
		PageUtil<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
		// 获取未签收的订单
		Integer count = 0;
		for (PurchaseOrder po : purchaseOrderList.getLists()) {
			if (po.getIsSignin() == 0) {
				count++;
			}
		}
		// 获取所有审核状态
		List<AuditState> auditStates = auditStateService.getAuditStates();
		model.addAttribute("partClassifyList", partClassifies);
		model.addAttribute("purchaseOrderList", purchaseOrderList);
		model.addAttribute("auditStateList", auditStates);
		// 存储审核状态，便于跳转时携带条件
		model.addAttribute("auditStateId", auditStateId);
		// 存储订单号，便于跳转时携带条件
		model.addAttribute("purchaseOrderId", purchaseOrderId);
		// 存储采购时间，便于跳转时携带条件
		model.addAttribute("purchaseTime", purchaseTime);
		// 存储零件类别，便于跳转时携带条件
		model.addAttribute("partType", partType);
		// 存储page对象
		model.addAttribute("page", purchaseOrderList);
		// 存储未签收订单数量
		model.addAttribute("notSigninCount", count);
		return "/purchasetask";
	}	
	
}
