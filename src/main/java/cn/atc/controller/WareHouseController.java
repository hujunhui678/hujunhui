package cn.atc.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import cn.atc.pojo.Orderform;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartType;
import cn.atc.pojo.PurchaseOrder;
import cn.atc.pojo.PurchaseOrderDesc;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.pojo.StoreHouseOutInRecord;
import cn.atc.service.AdminService;
import cn.atc.service.AuditStateService;
import cn.atc.service.FinishedProductsStockService;
import cn.atc.service.FinishedProductsTypeService;
import cn.atc.service.MaterialService;
import cn.atc.service.OrderformService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PartTypeService;
import cn.atc.service.ProductionPlanService;
import cn.atc.service.PurchaseOrderDescService;
import cn.atc.service.PurchaseOrderService;
import cn.atc.service.ReceiveCollectMaterialDescService;
import cn.atc.service.ReceiveCollectMaterialService;
import cn.atc.service.StoreHouseOutInDescRecordService;
import cn.atc.service.StoreHouseOutInRecordService;
import cn.atc.util.ExcelUtil;
import cn.atc.util.GsonUtil;
import cn.atc.util.IDUtil;
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
	private StoreHouseOutInDescRecordService storeHouseOutInDescRecordService;// ���������ϸ��¼

	@Autowired
	private ReceiveCollectMaterialService receiveCollectMaterialService;// �����ϵ�
	
	@Autowired
	private ReceiveCollectMaterialDescService receiveCollectMaterialDescService;// �����ϵ�����
	
	@Autowired
	private OrderformService orderFormService;// ���۶���
	
	@Autowired
	private ProductionPlanService productionPlanService;// �����ƻ�

	// ��ת������������ҳ
	@RequestMapping("/outInwarehouse")
	public String outwareHouse() {
		return "forward:getstorehouseoutinrecordsForm";
	}

	// ��ת�����ϵ�ҳ��
	@RequestMapping(value = "/materialmanage")
	public String materialmanage(Model model, Map<String, Object> map, String partType, String auditStateId,
			String materialId, String releaseTime, String currentPage, String totalPage,@RequestParam(value="isReceive",required=false,defaultValue="2")Integer isReceive) {
		map.put("isReceive", 2);
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

	// ��ת���ɹ������ҳ��
	@RequestMapping("/purchasetaskadd")
	public String purchasetaskadd(Model model,String[] partTypeList,String[] orderNumList,String[] partTypeIdList) {
		model.addAttribute("orderId",IDUtil.getId());
		List<MissPart> missPartList = new ArrayList<>();
		for (int i = 0; i < orderNumList.length; i++) {
			MissPart missPart = new MissPart();
			PartType partType = new PartType();
			partType.setId(Long.parseLong(partTypeIdList[i]));
			partType.setPartType(partTypeList[i]);
			missPart.setMissNum(Long.parseLong(orderNumList[i]));
			missPart.setPartType(partType);
			missPartList.add(missPart);
		}
		model.addAttribute("material",missPartList);
		return "/warehouse/purchasetask_add";
	}
	
	// ajax��Ӳɹ���
	@RequestMapping("dopurchaseaskadd")
	@ResponseBody
	public String dopurchaseaskadd(Map<String, Object>map,Long materialId,String[] partTypeIdList,String[] orderNumList,Map<String, Object> descMap) {
		Boolean flag = false;
		map.put("id",materialId.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("releaseTime",sdf.format(new Date()));
		if(purchaseOrderService.insertPurchaseOrder(map)>0) {
			for(int i = 0;i<partTypeIdList.length;i++) {
				descMap.put("partTypeId",partTypeIdList[i]);
				descMap.put("orderNum",orderNumList[i]);
				descMap.put("purchaseOrderId",materialId.toString());
				if(purchaseOrderDescService.insertPurchaseOrderDesc(descMap)<=0) {
					return "false";
				}
			}
			flag = true;
		}
		return flag.toString();
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
		model.addAttribute("inCount", storeHouseOutInRecordService.getIsInCount());
		model.addAttribute("outCount", storeHouseOutInRecordService.getIsOutCount());
		model.addAttribute("page", page);
		model.addAttribute("recordId", recordId);
		model.addAttribute("time", time);
		model.addAttribute("isOut", isOut);
		return "/warehouse/outinwarehouse";
	}

	// ��ȡ�������������
	@RequestMapping("/storehouseoutindescrecord")
	public String storehouseoutindescrecord(Model model,Long recordId) {
		List<StoreHouseOutInRecord> storeHouseOutInRecord = storeHouseOutInDescRecordService.getStoreHouseOutInRecordById(recordId);
		storeHouseOutInRecord.get(0).setTime(storeHouseOutInRecord.get(0).getTime().substring(0,19));
		model.addAttribute("storeHouse",storeHouseOutInRecord.get(0));
		return "/warehouse/storehouseoutindescrecord";
	}
	
	// ����������ȡ������Ʒ���������
	@RequestMapping("/storehouseoutindescrecordbymap")
	public String storehouseoutindescrecordbymap(Model model,Map<String, Object>map,Integer isOut,Long partTypeId,Long finishedProductId,int isLj) {
			map.put("partTypeId",partTypeId);
			map.put("finishedProductId",finishedProductId);
			map.put("isLj", isLj);
		List<StoreHouseOutInRecord> storeHouseOutInRecordByMap = storeHouseOutInDescRecordService.getStoreHouseOutInRecordByMap(map);
		if(storeHouseOutInRecordByMap==null || storeHouseOutInRecordByMap.size()==0) {
			model.addAttribute("emptyMsg","1");
		}else {
			model.addAttribute("record",storeHouseOutInRecordByMap);
		}
		model.addAttribute("isOut", isOut);
		model.addAttribute("isLj", isLj);
		return "/warehouse/storerecord";
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

	// �޸Ķ���ǩ��״̬���޸����ϱ�������(���ϵ�)
	@RequestMapping("/updateIsAgreeReceive")
	@ResponseBody
	public String updateIsAgreeReceive(Long id, Long adminId,long releaseDept,long releasePerson,long version, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// ������ʽ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����޸Ķ���ǩ��ʱ�Ĳ���
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		map.put("version", version);
		// ��ȡ���ϵ���������
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// �޸����ϵ�����״̬
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////�ֿ��������/////
			////////////////////////
			// �������/���ⵥ��
			long storeId = IDUtil.getId();
			// ����/����־
			Integer isOut = 2;
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
			storeHouseOutInRecord.put("releaseDept",releaseDept );
			storeHouseOutInRecord.put("releasePerson",releasePerson);
			
			////////////////////////
			////�ֿ������������////
			////////////////////////
			// ����һ��map���͵�List�����洢���ϵ��������
			List<Map<String, Object>> hasGoods = new ArrayList<Map<String, Object>>();
			// �Ƚ��в���ȡ������
			for (ReceiveCollectMaterialDesc receiveCollectMaterialDesc : materialDescByMaterialList.get(0).getReceiveCollectMaterialDescList()) {
				receiveCollectMaterialDesc.setFinishedPartTypeId(receiveCollectMaterialDesc.getFinishedProductsType().getId());
				if(materialService.getInFinishedProductsStock(receiveCollectMaterialDesc)<=0) {
					return "error";
				}
				// ����map����洢��������Ա��������������ϸ��¼����
				Map<String, Object> mapTemp = new HashMap<String, Object>();
				// �����¼ID
				mapTemp.put("outInRecordId", storeId);
				// ����������
				mapTemp.put("finishedProductId", receiveCollectMaterialDesc.getFinishedPartTypeId());
				// �����������
				mapTemp.put("num", receiveCollectMaterialDesc.getOrderNum());
				// ���
				mapTemp.put("goodsOnHand", 0);
				hasGoods.add(mapTemp);
			}
			// ���������¼��������¼
			if(!storeHouseOutInRecordService.insertStoreHouseOutInRecord(storeHouseOutInRecord, hasGoods)) {
				return "error";
			}
			return "yes";
		} else {
			return "no";
		}
	}
	
	// �޸Ķ���ǩ��״̬���޸����ϱ�������(���ϵ�)
	@RequestMapping("/updateIsAgreeById")
	@ResponseBody
	public String updateIsAgreeById(Long id, Long adminId,long leadingDept,long receivePerson,long version, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// ������ʽ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����޸Ķ���ǩ��ʱ�Ĳ���
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		map.put("version", version);
		// ��ȡ�����������
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// �޸����ϵ�����״̬
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////�ֿ��������/////
			////////////////////////
			// �������/���ⵥ��
			long storeId = IDUtil.getId();
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

	// �ɹ������ҳ����ת
	@RequestMapping("topurchasetaskaudit")
	public String purchasetaskaudit(Long orderId,Model model) {
		List<PurchaseOrderDesc> purchase = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		model.addAttribute("purchase",purchase);
		return "/warehouse/purchasetaskaudit";
	}
	
	// �޸����״̬(��˳ɹ�)
	@RequestMapping("updateauditstate")
	@ResponseBody
	public String updateAuditState(String orderId,String auditor,Map<String, Object>map) {
		map.put("id", orderId.substring(3));
		map.put("auditor", auditor);
		Integer result = purchaseOrderService.updateAuditStateId(map);
		return result.toString();
	}
	
	// �޸�δͨ����ע
	@RequestMapping("updatenotpassdesc")
	@ResponseBody
	public String updateNotPassDesc(String orderId,String notPassDesc,Map<String, Object>map) {
		map.put("id",orderId.substring(3));
		map.put("notPassDesc", notPassDesc);
		Integer result = purchaseOrderService.updateNotPassDesc(map);
		return result.toString();
	}
	
	// ��ת����д�ɹ�����ҳ
	@RequestMapping(value = "/purchasetaskchange")
	public String purchasetaskchange(Model model, Map<String, Object> map, String partType, String auditStateId,
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
	
	// ����Excel���
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response,Long shouId,Long lingId) throws Exception {
         //��ȡ����
         List<ReceiveCollectMaterial> receiveList = null;
         if(shouId!=null && shouId!=0) {
        	 receiveList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(shouId);
	         //excel����
	         String[] title = {"���","��Ʒ��","����"};
	         //excel�ļ���
	         String fileName = System.currentTimeMillis()+".xls";
	         //sheet��
	         String sheetName = "���ϵ���";
	         String[][] content =  new String[receiveList.get(0).getReceiveCollectMaterialDescList().size()][];
        	 for (int i = 0; i < receiveList.get(0).getReceiveCollectMaterialDescList().size(); i++) {
				 content[i] = new String[title.length];
		         ReceiveCollectMaterialDesc receiveDesc = receiveList.get(0).getReceiveCollectMaterialDescList().get(i);
		         content[i][0] = receiveDesc.getFinishedProductsType().getProductType();
		         content[i][1] = receiveDesc.getFinishedProductsType().getProductName();
		         content[i][2] = receiveDesc.getOrderNum()+"";
	         }
        	//����HSSFWorkbook 
        	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null,receiveList);
        	
			//��Ӧ���ͻ���
			try {
				this.setResponseHeader(response, fileName);
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
         }else {
        	 receiveList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(lingId);
	         //excel����
	         String[] title = {"����","���","����"};
	         //excel�ļ���
	         String fileName = System.currentTimeMillis()+".xls";
	         //sheet��
	         String sheetName = "���ϵ���";
	         String[][] content =  new String[receiveList.get(0).getReceiveCollectMaterialDescList().size()][];
        	 for (int i = 0; i < receiveList.get(0).getReceiveCollectMaterialDescList().size(); i++) {
				 content[i] = new String[title.length];
		         ReceiveCollectMaterialDesc receiveDesc = receiveList.get(0).getReceiveCollectMaterialDescList().get(i);
		         content[i][0] = receiveDesc.getPartType().getPartClassify().getPartName();
		         content[i][1] = receiveDesc.getPartType().getPartType();
		         content[i][2] = receiveDesc.getOrderNum()+"";
	         }
        	//����HSSFWorkbook 
        	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null,receiveList);

			//��Ӧ���ͻ���
			try {
				this.setResponseHeader(response, fileName);
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
         }
		}

    // ������Ӧ������
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // �ж���������Ƿ����(��Ҫ��ѯ��Ʒ����)���������㷵��ȱʧ�������������
    @RequestMapping("/comparisonFinishedPart")
    @ResponseBody
    public String comparisonFinishedPart(long finishedType,long orderNum) {
    	FinishedProductsStock finishedPart = finishedProductsStockService.getFinishedPartById(finishedType);
    	return GsonUtil.GsonString(finishedPart);
    }
    
    // ��Ʒ�������
    @RequestMapping("/finishedPartOut")
    @ResponseBody
    public String finishedPartOut(Long orderId,Long finishedType,Long orderNum,Long adminId) {
    	try {
    		Map<String, Object> storeHouseOutInRecord = new HashMap<String, Object>();
        	Map<String, Object> storeHouseOutInDescRecordMap = new HashMap<String, Object>();
    		////////////////////////
    		////�ֿ��Ʒ��������////
    		////////////////////////
    		// �������/���ⵥ��
    		long storeId = IDUtil.getId();
    		// ����/����־
    		Integer isOut = 1;
    		// �����ʱ��(��ǰʱ��)
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    		storeHouseOutInRecord.put("receivePerson",13);
    		storeHouseOutInRecord.put("leadingDept",2);
    		storeHouseOutInRecord.put("releaseDept",2);
    		storeHouseOutInRecord.put("releasePerson",13);
    		
    		////////////////////////
    		////�ֿ������������////
    		////////////////////////
    		List<Map<String, Object>> storeHouseOutInDescRecord = new ArrayList<Map<String,Object>>();
    		storeHouseOutInDescRecordMap.put("outInRecordId",storeId);
    		storeHouseOutInDescRecordMap.put("finishedProductId",finishedType);
    		storeHouseOutInDescRecordMap.put("num",orderNum);
    		storeHouseOutInDescRecordMap.put("goodsOnHand",0);
    		storeHouseOutInDescRecord.add(storeHouseOutInDescRecordMap);
    		boolean insertStoreHouseOutInRecordResult = storeHouseOutInRecordService.insertStoreHouseOutInRecord(storeHouseOutInRecord, storeHouseOutInDescRecord);
    		if(insertStoreHouseOutInRecordResult) {
    			Orderform orderForm = new Orderform();
    			orderForm.setState(2);
    			orderForm.setId(orderId.toString());
    			if(orderFormService.update(orderForm)>0) {
    				// ���³�Ʒ���
    				Map<String, Object> partMap = new HashMap<String,Object>();
    				partMap.put("num",orderNum );
    				partMap.put("productId", finishedType);
    				Integer updateResult = finishedProductsStockService.updateFinishedPartNum(partMap);
    				if(updateResult>0) {
    					return "yes";
    				}else {
    					return "no";
    				}
    			}else {
    				return "no";
    			}
    		}else {
    			return "no";
    		}
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
    }

    // ��Ʒ��治�㷢�������ƻ�
    @RequestMapping("/sendoutproductionplan")
    @ResponseBody
    public String sendoutproductionplan(Map<String, Object>map,Long finishedProductTypeId,Long produceNum) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	// �����ƻ�����
        	map.put("id","ATC_"+IDUtil.getId());
        	// ��Ʒ�ͺ�
        	map.put("finishedProductTypeId", finishedProductTypeId);
        	// ��������
        	map.put("produceNum",produceNum);
        	// ��д��Ա
        	map.put("compilers",2);
        	// �´�����
        	map.put("arrivalTime", sdf.format(new Date()));
        	// Ԥ�����ʱ��
            Date date=new Date();  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(Calendar.DAY_OF_MONTH, +3);  
            date = calendar.getTime();  
        	map.put("estimatedTimeOfCompletion", date);
        	// ���״̬
        	map.put("auditStateId",1);
        	// ��������ƻ�
        	if(productionPlanService.addProductionPlan(map)>0) {
        		return "yes";
        	}
        	return "no";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
    }
}