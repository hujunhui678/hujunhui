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
 * �ֿ���������
 * 
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/page")
public class WareHouseController {

	@Autowired
	private PartClassifyService partClassifyService; // ������

	@Autowired
	private PurchaseOrderService purchaseOrderService;// �ɹ�����

	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;// �ɹ�������ϸ

	@Autowired
	private AuditStateService auditStateService;// ���״̬
	
	@Autowired
	private InventoryOfPartsService inventoryOfPartsService;// ������
	
	@Autowired
	private MaterialService materialService;// ë�����

	// ��ת��������ҳ
	@RequestMapping("/inwarehouse")
	public String inwareHouse() {
		return "inwarehouse";
	}

	// ��ת���������ҳ
	@RequestMapping("/outwarehouse")
	public String outwareHouse() {
		return "outwarehouse";
	}

	// ��ת���ɹ�����ҳ
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
		return "/warehouse/purchasetask";
	}
	
	// ��ת���ֿ���ҳ��
	@RequestMapping("/materialstock")
	public String inventoryofparts(Model model) {
		List<PartClassify> partClassifyList = partClassifyService.getAllPartClassifies();
		model.addAttribute("partClassifyList",partClassifyList);
		return "/warehouse/inventoryofparts";
	}
	
	// ajax��ȡë���������
	@RequestMapping("/getmeterials")
	@ResponseBody
	public String getMeterials(Model model,Map<String, Object>map,String partType,String partClassId,String currentPage) {
		map.put("partType",partType);
		map.put("currentPage", currentPage);
		map.put("partClassId", partClassId);
		PageUtil<Material> materialList = materialService.getMaterialsByCondition(map);
		return GsonUtil.GsonString(materialList);
	}
	
	// ��ȡ�ɹ�����������Ϣ��ʹ��json����
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
	
	// �ж���������Ƿ����(��Ҫ��ѯ���Ͽ���)
	@RequestMapping("/comparisonMaterial")
	@ResponseBody
	public String comparisonMaterial(Long orderId) {
		// ��ȡ�����������
		List<PurchaseOrderDesc> orderList = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		// ��ȡ������в���
		List<InventoryOfParts> inventoryOfPartList = inventoryOfPartsService.getInventoryOfParts();
		// �½�һ��List�����洢ȱ�ٵ����
		List<MissPart> missPartList = new ArrayList<MissPart>();
		for (InventoryOfParts part : inventoryOfPartList) {
			for (PurchaseOrderDesc order : orderList) {
				if(part.getPartId()==order.getPartType().getId()) {
					if(order.getOrderNum()<part.getInventoryNum()) {
						// ��治��
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