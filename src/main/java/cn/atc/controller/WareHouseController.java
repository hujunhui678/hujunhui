package cn.atc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.MissPart;
import cn.atc.pojo.Admin;
import cn.atc.pojo.AuditState;
import cn.atc.pojo.FinishedProductsStock;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.Material;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartType;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.pojo.StoreHouseOutInDescRecord;
import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.service.AdminService;
import cn.atc.service.AuditStateService;
import cn.atc.service.FinishedProductsStockService;
import cn.atc.service.FinishedProductsTypeService;
import cn.atc.service.InventoryOfPartsService;
import cn.atc.service.MaterialService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PartTypeService;
import cn.atc.service.PurchaseOrderDescService;
import cn.atc.service.PurchaseOrderService;
import cn.atc.service.ReceiveCollectMaterialDescService;
import cn.atc.service.ReceiveCollectMaterialService;
import cn.atc.service.StoreHouseOutInRecordService;
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
	private AdminService adminService;// �û�
	
	@Autowired
	private PartClassifyService partClassifyService; // ������

	@Autowired
	private PurchaseOrderService purchaseOrderService;// �ɹ�����

	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;// �ɹ�������ϸ

	@Autowired
	private AuditStateService auditStateService;// ���״̬

	@Autowired
	private MaterialService materialService;// ë�����

	@Autowired
	private PartTypeService partTypeService;// ����ͺ�

	@Autowired
	private FinishedProductsStockService finishedProductsStockService;// ��Ʒ���

	@Autowired
	private FinishedProductsTypeService finishedProductsTypeService;// ��Ʒ���

	@Autowired
	private StoreHouseOutInRecordService storeHouseOutInRecordService;// ��������¼

	@Autowired
	private ReceiveCollectMaterialService receiveCollectMaterialService;// �����ϵ�
	
	@Autowired
	private ReceiveCollectMaterialDescService receiveCollectMaterialDescService;// �����ϵ�����

	// ��ת������������ҳ
	@RequestMapping("/outInwarehouse")
	public String outwareHouse() {
		return "forward:getstorehouseoutinrecordsForm";
	}

	// ��ת�����ϵ�ҳ��
	@RequestMapping(value = "/materialmanage")
	public String materialmanage(Model model, Map<String, Object> map, String partType, String auditStateId,
			String materialId, String releaseTime, String currentPage, String totalPage,@RequestParam(value="isReceive",required=false,defaultValue="2")Integer isReceive) {
		map.put("isReceive", isReceive);
		map.put("auditStateId", auditStateId);
		map.put("materialId", materialId);
		map.put("releaseTime", releaseTime);
		map.put("currentPage", currentPage);
		// ��ȡ�����ϵ����������
		PageUtil<ReceiveCollectMaterial> receiveCollectMaterialList = receiveCollectMaterialService
				.getReceiveCollectMaterialByCondition(map);
		// ��ȡδ��׼�����ϵ�����
		Integer count = 0;
		for (ReceiveCollectMaterial re : receiveCollectMaterialList.getLists()) {
			if (re.getIsAgree() == 2) {
				count++;
			}
		}
		// �淶ʱ���ʽ
		for (ReceiveCollectMaterial re : receiveCollectMaterialList.getLists()) {
			if(re!=null ) {
				if(re.getAuditTime()!=null) {
					re.setAuditTime(re.getAuditTime().substring(0, 16));
				}
				if(re.getReleaseTime()!=null) {
					re.setReleaseTime(re.getReleaseTime().substring(0, 16));
				}
			}
		}
		// ��ȡ�������״̬
		List<AuditState> auditStates = auditStateService.getAuditStates();
		model.addAttribute("receiveCollectMaterialList", receiveCollectMaterialList);
		model.addAttribute("auditStateList", auditStates);
		// �洢���״̬��������תʱЯ������
		model.addAttribute("auditStateId", auditStateId);
		// �洢���쵥�ţ�������תʱЯ������
		model.addAttribute("materialId", materialId);
		// �洢����ʱ�䣬������תʱЯ������
		model.addAttribute("releaseTime", releaseTime);
		// �洢page����
		model.addAttribute("page", receiveCollectMaterialList);
		// �洢δǩ�ն�������
		model.addAttribute("notAgreeCount", count);
		return "/warehouse/materialmanage";
	}

	// ��ת�����ϵ�ҳ��
	@RequestMapping(value = "/receivemanage")
	@ResponseBody
	public String receivemanage(Model model, Map<String, Object> map, String currentPage, String totalPage) {
		map.put("isReceive",1);
		map.put("currentPage", currentPage);
		// ��ȡ���ϵ����������
		PageUtil<ReceiveCollectMaterial> receiveCollectMaterialList = receiveCollectMaterialService
				.getReceiveCollectMaterialByCondition(map);
		// �淶ʱ���ʽ
		for (ReceiveCollectMaterial re : receiveCollectMaterialList.getLists()) {
			if(re!=null ) {
				if(re.getAuditTime()!=null) {
					re.setAuditTime(re.getAuditTime().substring(0, 16));
				}
				if(re.getReleaseTime()!=null) {
					re.setReleaseTime(re.getReleaseTime().substring(0, 16));
				}
			}
		}
		return GsonUtil.GsonString(receiveCollectMaterialList);
	}
	
	// ��ת���ֿ���ҳ��
	@RequestMapping("/materialstock")
	public String inventoryofparts(Model model) {
		List<PartClassify> partClassifyList = partClassifyService.getAllPartClassifies();
		model.addAttribute("partClassifyList", partClassifyList);
		return "/warehouse/inventoryofparts";
	}

	// ajax��ȡë���������
	@RequestMapping("/getmeterials")
	@ResponseBody
	public String getMeterials(Model model, Map<String, Object> map, String partType, String partClassId,
			String currentPage) {
		map.put("partType", partType);
		map.put("currentPage", currentPage);
		map.put("partClassId", partClassId);
		PageUtil<Material> materialList = materialService.getMaterialsByCondition(map);
		return GsonUtil.GsonString(materialList);
	}

	// ajax��ȡ��Ʒ�������
	@RequestMapping("/getfinishedproductsstocks")
	@ResponseBody
	public String getfinishedproductsstocks(Model model, Map<String, Object> map, String currentPage) {
		map.put("currentPage", currentPage);
		PageUtil<FinishedProductsStock> page = finishedProductsStockService.getFinishedProductsStocks(map);
		return GsonUtil.GsonString(page);
	}

	// ajax��ȡ��������¼����
	@RequestMapping("/getstorehouseoutinrecords")
	@ResponseBody
	public String getstorehouseoutinrecords(Model model, Map<String, Object> map, String currentPage, String recordId,
			String time, Integer isOut) {
		map.put("recordId", recordId);
		map.put("time", time);
		map.put("isOut", isOut);
		map.put("currentPage", currentPage);
		PageUtil<StoreHouseOutInRecord> page = storeHouseOutInRecordService.getStoreHouseOutInRecordByCondition(map);
		for (StoreHouseOutInRecord record : page.getLists()) {
			record.setSid(record.getId() + "");
			if (record.getRemark() == null) {
				record.setRemark("");
			}
		}
		return GsonUtil.GsonString(page);
	}

	// ����ȡ��������¼����
	@RequestMapping("/getstorehouseoutinrecordsForm")
	public String getstorehouseoutinrecordsform(Model model, Map<String, Object> map, String currentPage,
			String recordId, String time, Integer isOut) {
		Integer inCount = 0;// ����¼����
		Integer outCount = 0;// �����¼����
		map.put("recordId", recordId);
		map.put("time", time);
		map.put("isOut", isOut);
		map.put("currentPage", currentPage);
		PageUtil<StoreHouseOutInRecord> page = storeHouseOutInRecordService.getStoreHouseOutInRecordByCondition(map);
		for (StoreHouseOutInRecord record : page.getLists()) {
			if (record.getIsOut() == 1) {
				outCount++;
			} else {
				inCount++;
			}
		}
		model.addAttribute("inCount", inCount);
		model.addAttribute("outCount", outCount);
		model.addAttribute("page", page);
		model.addAttribute("recordId", recordId);
		model.addAttribute("time", time);
		model.addAttribute("isOut", isOut);
		return "/warehouse/outinwarehouse";
	}

	// ajax�������ͺ�
	@RequestMapping("/insertparttype")
	@ResponseBody
	public String insertPartType(PartType partType) {
		Integer result = partTypeService.insertPartType(partType);
		return result.toString();
	}

	// ajax��ӳ�Ʒ���
	@RequestMapping("/insertfinishedproductstype")
	@ResponseBody
	public String insertFinishedProductsType(FinishedProductsType finishedProductsType) {
		Integer result = finishedProductsTypeService.insertFinishedProductsType(finishedProductsType);
		return result.toString();
	}

	// ajax��ȡ�ɹ�����������Ϣ��ʹ��json����
	@RequestMapping("/getMaterialDesc")
	@ResponseBody
	public String getMaterialDesc(Long materialId) {
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(materialId);
		// �淶ʱ���ʽ
		for (ReceiveCollectMaterial re : materialDescByMaterialList) {
			if(re!=null ) {
				if(re.getAuditTime()!=null) {
					re.setAuditTime(re.getAuditTime().substring(0, 16));
				}
				if(re.getReleaseTime()!=null) {
					re.setReleaseTime(re.getReleaseTime().substring(0, 16));
				}
				if(re.getAgreeTime()!=null) {
					re.setAgreeTime(re.getAgreeTime().substring(0,16));
				}
			}
		}
		String orderList = GsonUtil.GsonString(materialDescByMaterialList);
		return orderList;
	}

	// �޸Ķ���ǩ��״̬���޸����ϱ�������
	@RequestMapping("/updateIsAgreeById")
	@ResponseBody
	public String updateIsAgreeById(Long id, Long adminId,long leadingDept,long receivePerson, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// ������ʽ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����޸Ķ���ǩ��ʱ�Ĳ���
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		// ��ȡ�����������
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// �޸����ϵ�����״̬
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////�ֿ��������/////
			////////////////////////
			// ��λ�������ȡ
			Integer numFour=(int)(Math.random()*8999)+1000;
			// �̶���ʽʱ���ȡ
			SimpleDateFormat sdfId = new SimpleDateFormat("yyyyMMddHHmm");
			String time = sdfId.format(new Date());
			// �������/���ⵥ��
			long storeId = Long.parseLong(numFour.toString()+time);
			// ����/����־
			Integer isOut = 1;
			// �����ʱ��(��ǰʱ��)
			String timeNow = sdf.format(new Date());
			// �������
			Admin admin = adminService.getAdmin(adminId.intValue());
			// �����������
			String empName = admin.getName();
			// ����⸺����
			long principal = adminId;
			// ������(receivePerson)
			// ���ò��ţ�leadingDept)
			// ��Ųֿ�������
			storeHouseOutInRecord.put("id",storeId);
			storeHouseOutInRecord.put("isOut", isOut);
			storeHouseOutInRecord.put("time", timeNow);
			storeHouseOutInRecord.put("empName", empName);
			storeHouseOutInRecord.put("principal", principal);
			storeHouseOutInRecord.put("receivePerson",receivePerson );
			storeHouseOutInRecord.put("leadingDept",leadingDept);
			
			////////////////////////
			////�ֿ������������////
			////////////////////////
			// ����һ��map���͵�List�����洢���ϵ��������
			List<Map<String, Object>> needGoods = new ArrayList<Map<String, Object>>();
			// �Ƚ��в���ȡ������
			for (ReceiveCollectMaterialDesc receiveCollectMaterialDesc : materialDescByMaterialList.get(0).getReceiveCollectMaterialDescList()) {
				if(materialService.getOutMaterials(receiveCollectMaterialDesc)<=0) {
					return "error";
				}
				// ����map����洢��������Ա��������������ϸ��¼����
				Map<String, Object> mapTemp = new HashMap<String, Object>();
				// �����¼ID
				mapTemp.put("outInRecordId", storeId);
				// ����������
				mapTemp.put("partTypeId", receiveCollectMaterialDesc.getPartTypeId());
				// �����������
				mapTemp.put("num", receiveCollectMaterialDesc.getOrderNum());
				// ���
				mapTemp.put("goodsOnHand", 0);
				needGoods.add(mapTemp);
			}
			// ���������¼��������¼
			if(!storeHouseOutInRecordService.insertStoreHouseOutInRecord(storeHouseOutInRecord, needGoods)) {
				return "error";
			}
			return "yes";
		} else {
			return "no";
		}
	}

	// �ж���������Ƿ����(��Ҫ��ѯ���Ͽ���)���������㷵��ȱʧ�������������
	@RequestMapping("/comparisonMaterial")
	@ResponseBody
	public String comparisonMaterial(Long materialId) {
		// ��ȡ�����������
		List<ReceiveCollectMaterial> list = receiveCollectMaterialDescService.getMaterialDescByMaterialId(materialId);
		// ��ȡ������в���
		List<Material> allMaterials = materialService.getAllMaterials();
		List<ReceiveCollectMaterialDesc> materialDescList = list.get(0).getReceiveCollectMaterialDescList();
		// �½�һ��List�����洢ȱ�ٵ����
		List<MissPart> missPartList = new ArrayList<MissPart>();
		for (Material material : allMaterials) {
			for (ReceiveCollectMaterialDesc materialDesc : materialDescList) {
				if (material.getMatType() == materialDesc.getPartType().getId()) {
					if (materialDesc.getOrderNum() > material.getInventoryNum()) {
						// ��治��
						MissPart missPart = new MissPart();
						missPart.setMissNum(materialDesc.getOrderNum()-material.getInventoryNum());
						missPart.setPartTypeId(materialDesc.getPartTypeId());
						missPart.setPartClassId(materialDesc.getPartType().getId());
						missPart.setPartType(materialDesc.getPartType());
						missPart.setPartClassify(materialDesc.getPartType().getPartClassify());
						missPartList.add(missPart);
					}
				}
			}
		}
		return GsonUtil.GsonString(missPartList);
	}

}