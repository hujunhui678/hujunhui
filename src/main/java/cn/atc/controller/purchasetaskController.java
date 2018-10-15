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
import cn.atc.service.impl.PurchaseOrderDescServiceImpl;
import cn.atc.service.impl.PurchaseOrderServiceImpl;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class purchasetaskController {
	// ajax��ȡ�ɹ�����������Ϣ��ʹ��json����
	@Autowired
		PurchaseOrderDescService purchaseOrderDescService;
	@Autowired
		PurchaseOrderService purchaseOrderService;
	@Autowired
	PartClassifyService partClassifyService;
	@Autowired
	AuditStateService auditStateService;
	@RequestMapping("/getPurchaseOrderDesc")
	@ResponseBody
	public String getPurchaseOrderDesc(Long orderId) {
		List<PurchaseOrderDesc> orders = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		String orderList = GsonUtil.GsonString(orders);
		return orderList;
	}

	// �޸Ķ���ǩ��״̬
	@RequestMapping("/updateIsSigninById")
	@ResponseBody
	public String updateIsSigninById(Long id, Long adminId, Map<String, Object> map) {
		map.put("id", id);
		map.put("adminId", adminId);
		Integer result = purchaseOrderService.updateIsSigninById(map);
		if (result > 0) {
			return "yes";
		} else {
			return "no";
		}
	}

	// ��ת���ɹ�����ҳ
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
		// ��ȡ����������
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// ��ȡ�ɹ��������������
		PageUtil<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
		// ��ȡδǩ�յĶ���
		Integer count = 0;
		for (PurchaseOrder po : purchaseOrderList.getLists()) {
			if (po.getIsSignin() == 0) {
				count++;
			}
		}
		// ��ȡ�������״̬
		List<AuditState> auditStates = auditStateService.getAuditStates();
		model.addAttribute("partClassifyList", partClassifies);
		model.addAttribute("purchaseOrderList", purchaseOrderList);
		model.addAttribute("auditStateList", auditStates);
		// �洢���״̬��������תʱЯ������
		model.addAttribute("auditStateId", auditStateId);
		// �洢�����ţ�������תʱЯ������
		model.addAttribute("purchaseOrderId", purchaseOrderId);
		// �洢�ɹ�ʱ�䣬������תʱЯ������
		model.addAttribute("purchaseTime", purchaseTime);
		// �洢�����𣬱�����תʱЯ������
		model.addAttribute("partType", partType);
		// �洢page����
		model.addAttribute("page", purchaseOrderList);
		// �洢δǩ�ն�������
		model.addAttribute("notSigninCount", count);
		return "/purchasetask";
	}	
	
}
