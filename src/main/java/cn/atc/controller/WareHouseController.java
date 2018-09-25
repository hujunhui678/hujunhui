package cn.atc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PurchaseOrderService;

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
	public String purchasetask(Model model,Map<String, Object> map) {
		// 获取所有零件类别
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// 获取采购订单表基础数据
		List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
		model.addAttribute("partClassifyList", partClassifies);
		model.addAttribute("purchaseOrderList", purchaseOrderList);
		return "/warehouse/purchasetask";
	}
}
