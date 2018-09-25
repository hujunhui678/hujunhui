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
	public String purchasetask(Model model,Map<String, Object> map) {
		// ��ȡ����������
		List<PartClassify> partClassifies = partClassifyService.getAllPartClassifies();
		// ��ȡ�ɹ��������������
		List<PurchaseOrder> purchaseOrderList = purchaseOrderService.getPurchaseOrdersByCondition(map);
		model.addAttribute("partClassifyList", partClassifies);
		model.addAttribute("purchaseOrderList", purchaseOrderList);
		return "/warehouse/purchasetask";
	}
}
