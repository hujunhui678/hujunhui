package cn.atc.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.MissPart;
import cn.atc.pojo.AuditState;
import cn.atc.pojo.InventoryOfParts;
import cn.atc.pojo.Material;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartType;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;
import cn.atc.service.AuditStateService;
import cn.atc.service.InventoryOfPartsService;
import cn.atc.service.MaterialService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PurchaseOrderDescService;
import cn.atc.service.PurchaseOrderService;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

/**
 * 仓库管理控制器
 * 
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/page")
public class WareHouseController {

	@Autowired
	private PartClassifyService partClassifyService; // 零件类别

	@Autowired
	private PurchaseOrderService purchaseOrderService;// 采购订单

	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;// 采购订单详细

	@Autowired
	private AuditStateService auditStateService;// 审核状态
	
	@Autowired
	private InventoryOfPartsService inventoryOfPartsService;// 零件库存
	
	@Autowired
	private MaterialService materialService;// 毛坯库存

	// 跳转到入库管理页
	@RequestMapping("/inwarehouse")
	public String inwareHouse() {
		return "inwarehouse";
	}

	// 跳转到出库管理页
	@RequestMapping("/outwarehouse")
	public String outwareHouse() {
		return "outwarehouse";
	}

	// 跳转到采购任务单页
	@RequestMapping(value = "/purchasetask")
	public String purchasetask(Model model, Map<String, Object> map, String partType, String auditStateId,
			String purchaseOrderId, String purchaseTime, String currentPage, String totalPage) {
		if(purchaseOrderId!=null) {
			if(purchaseOrderId.contains("ATC")){
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
		return "/warehouse/purchasetask";
	}
	
	// 跳转到仓库库存页面
	@RequestMapping("/materialstock")
	public String inventoryofparts(Model model) {
		List<PartClassify> partClassifyList = partClassifyService.getAllPartClassifies();
		model.addAttribute("partClassifyList",partClassifyList);
		return "/warehouse/inventoryofparts";
	}
	
	// ajax获取毛坯库存数据
	@RequestMapping("/getmeterials")
	@ResponseBody
	public String getMeterials(Model model,Map<String, Object>map,String partType,String partClassId,String currentPage) {
		map.put("partType",partType);
		map.put("currentPage", currentPage);
		map.put("partClassId", partClassId);
		PageUtil<Material> materialList = materialService.getMaterialsByCondition(map);
		return GsonUtil.GsonString(materialList);
	}
	
	// 获取采购订单详情信息并使用json返回
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
	public String updateIsSigninById(Long id,Long adminId,Map<String, Object>map) {
		map.put("id",id);
		map.put("adminId", adminId);
		Integer result = purchaseOrderService.updateIsSigninById(map);
		if(result>0) {
			return "yes";
		}else {
			return "no";
		}
	}
	
	// 判断所需材料是否充足(需要查询材料库存表)
	@RequestMapping("/comparisonMaterial")
	@ResponseBody
	public String comparisonMaterial(Long orderId) {
		// 获取订单所需材料
		List<PurchaseOrderDesc> orderList = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		// 获取库存所有材料
		List<InventoryOfParts> inventoryOfPartList = inventoryOfPartsService.getInventoryOfParts();
		// 新建一个List用来存储缺少的零件
		List<MissPart> missPartList = new ArrayList<MissPart>();
		for (InventoryOfParts part : inventoryOfPartList) {
			for (PurchaseOrderDesc order : orderList) {
				if(part.getPartId()==order.getPartType().getId()) {
					if(order.getOrderNum()<part.getInventoryNum()) {
						// 库存不足
						MissPart missPart = new MissPart();
						missPart.setPartTypeId(order.getPartTypeId());
						missPart.setPartClassId(order.getPartType().getId());
						missPart.setPartType(order.getPartType());
						missPart.setPartClassify(order.getPartType().getPartClassify());
						missPartList.add(missPart);
					}
				}
			}
		}
		return GsonUtil.GsonString(missPartList);
	}
}