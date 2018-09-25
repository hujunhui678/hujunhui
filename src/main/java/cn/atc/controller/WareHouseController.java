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
 * �ֿ���������
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/page")
public class WareHouseController {
	
	@Autowired
	private PartClassifyService partClassifyService; //������
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;//�ɹ�����
	
	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;//�ɹ�������ϸ
	
	@Autowired
	private AuditStateService auditStateService;//���״̬
	
	//��ת��������ҳ
	@RequestMapping("/inwarehouse")
	public String inwareHouse() {
		return "inwarehouse";
	}

	//��ת���������ҳ
	@RequestMapping("/outwarehouse")
	public String outwareHouse() {
		return "outwarehouse";
	}

	//��ת���ɹ�����ҳ
	@RequestMapping("/purchasetask")
	public String purchasetask(Model model,Map<String, Object> map,String partType,Integer auditStateId,Integer purchaseOrderId,String purchaseTime) {
		map.put("auditStateId",auditStateId);
		map.put("purchaseOrderId", purchaseOrderId);
		map.put("purchaseTime", purchaseTime);
		map.put("partType", partType);
		// ��ȡ����������
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// ��ȡ�ɹ��������������
		List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
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
		return "/warehouse/purchasetask";
	}
	
	//��ȡ�ɹ�����������Ϣ��ʹ��json����
	@RequestMapping("/getPurchaseOrderDesc")
	@ResponseBody
	public String getPurchaseOrderDesc(Long orderId) {
		List<PurchaseOrderDesc> orders = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		String orderList = GsonUtil.GsonString(orders);
		return orderList;
	}
}