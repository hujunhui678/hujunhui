package cn.atc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.pojo.AuditState;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;
import cn.atc.service.AuditStateService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PurchaseOrderDescService;
import cn.atc.service.PurchaseOrderService;
import cn.atc.util.GsonUtil;

/**
 * 仓库管理控制器
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/page")
public class WareHouseController {
	
	@Autowired
	private PartClassifyService partClassifyService; //零件类别
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;//采购订单
	
	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;//采购订单详细
	
	@Autowired
	private AuditStateService auditStateService;//审核状态
	
	//跳转到入库管理页
	@RequestMapping("/inwarehouse")
	public String inwareHouse() {
		return "inwarehouse";
	}

	//跳转到出库管理页
	@RequestMapping("/outwarehouse")
	public String outwareHouse() {
		return "outwarehouse";
	}

	//跳转到采购任务单页
	@RequestMapping("/purchasetask")
	public String purchasetask(Model model,Map<String, Object> map,String partType,Integer auditStateId,Integer purchaseOrderId,String purchaseTime) {
		map.put("auditStateId",auditStateId);
		map.put("purchaseOrderId", purchaseOrderId);
		map.put("purchaseTime", purchaseTime);
		map.put("partType", partType);
		// 获取所有零件类别
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// 获取采购订单表基础数据
		List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
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
		return "/warehouse/purchasetask";
	}
	
	//获取采购订单详情信息并使用json返回
	@RequestMapping("/getPurchaseOrderDesc")
	@ResponseBody
	public String getPurchaseOrderDesc(Long orderId) {
		List<PurchaseOrderDesc> orders = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		String orderList = GsonUtil.GsonString(orders);
		return orderList;
	}
}