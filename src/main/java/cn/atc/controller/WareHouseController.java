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
 * 仓库管理控制器
 * 
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/page")
public class WareHouseController {

	@Autowired
	private AdminService adminService;// 用户
	
	@Autowired
	private PartClassifyService partClassifyService; // 零件类别

	@Autowired
	private PurchaseOrderService purchaseOrderService;// 采购订单

	@Autowired
	private PurchaseOrderDescService purchaseOrderDescService;// 采购订单详细

	@Autowired
	private AuditStateService auditStateService;// 审核状态

	@Autowired
	private MaterialService materialService;// 毛坯库存

	@Autowired
	private PartTypeService partTypeService;// 零件型号

	@Autowired
	private FinishedProductsStockService finishedProductsStockService;// 成品库存

	@Autowired
	private FinishedProductsTypeService finishedProductsTypeService;// 成品类别

	@Autowired
	private StoreHouseOutInRecordService storeHouseOutInRecordService;// 出库入库记录
	
	@Autowired
	private StoreHouseOutInDescRecordService storeHouseOutInDescRecordService;// 出库入库详细记录

	@Autowired
	private ReceiveCollectMaterialService receiveCollectMaterialService;// 收领料单
	
	@Autowired
	private ReceiveCollectMaterialDescService receiveCollectMaterialDescService;// 收领料单详情
	
	@Autowired
	private OrderformService orderFormService;// 销售订单
	
	@Autowired
	private ProductionPlanService productionPlanService;// 生产计划

	// 跳转到出库入库管理页
	@RequestMapping("/outInwarehouse")
	public String outwareHouse() {
		return "forward:getstorehouseoutinrecordsForm";
	}

	// 跳转到领料单页面
	@RequestMapping(value = "/materialmanage")
	public String materialmanage(Model model, Map<String, Object> map, String partType, String auditStateId,
			String materialId, String releaseTime, String currentPage, String totalPage,@RequestParam(value="isReceive",required=false,defaultValue="2")Integer isReceive) {
		map.put("isReceive", 2);
		map.put("auditStateId", auditStateId);
		map.put("materialId", materialId);
		map.put("releaseTime", releaseTime);
		map.put("currentPage", currentPage);
		// 获取收领料单表基础数据
		PageUtil<ReceiveCollectMaterial> receiveCollectMaterialList = receiveCollectMaterialService
				.getReceiveCollectMaterialByCondition(map);
		// 获取未批准的领料单数量
		Integer count = 0;
		for (ReceiveCollectMaterial re : receiveCollectMaterialList.getLists()) {
			if (re.getIsAgree() == 2) {
				count++;
			}
		}
		// 规范时间格式
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
		// 获取所有审核状态
		List<AuditState> auditStates = auditStateService.getAuditStates();
		model.addAttribute("receiveCollectMaterialList", receiveCollectMaterialList);
		model.addAttribute("auditStateList", auditStates);
		// 存储审核状态，便于跳转时携带条件
		model.addAttribute("auditStateId", auditStateId);
		// 存储收领单号，便于跳转时携带条件
		model.addAttribute("materialId", materialId);
		// 存储发布时间，便于跳转时携带条件
		model.addAttribute("releaseTime", releaseTime);
		// 存储page对象
		model.addAttribute("page", receiveCollectMaterialList);
		// 存储未签收订单数量
		model.addAttribute("notAgreeCount", count);
		return "/warehouse/materialmanage";
	}

	// 跳转到收料单页面
	@RequestMapping(value = "/receivemanage")
	@ResponseBody
	public String receivemanage(Model model, Map<String, Object> map, String currentPage, String totalPage) {
		map.put("isReceive",1);
		map.put("currentPage", currentPage);
		// 获取收料单表基础数据
		PageUtil<ReceiveCollectMaterial> receiveCollectMaterialList = receiveCollectMaterialService
				.getReceiveCollectMaterialByCondition(map);
		// 规范时间格式
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
	
	// 跳转到仓库库存页面
	@RequestMapping("/materialstock")
	public String inventoryofparts(Model model) {
		List<PartClassify> partClassifyList = partClassifyService.getAllPartClassifies();
		model.addAttribute("partClassifyList", partClassifyList);
		return "/warehouse/inventoryofparts";
	}

	// 跳转到采购单添加页面
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
	
	// ajax添加采购单
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
	
	// ajax获取毛坯库存数据
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

	// ajax获取成品库存数据
	@RequestMapping("/getfinishedproductsstocks")
	@ResponseBody
	public String getfinishedproductsstocks(Model model, Map<String, Object> map, String currentPage) {
		map.put("currentPage", currentPage);
		PageUtil<FinishedProductsStock> page = finishedProductsStockService.getFinishedProductsStocks(map);
		return GsonUtil.GsonString(page);
	}

	// ajax获取出库入库记录数据
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

	// 表单获取出库入库记录数据
	@RequestMapping("/getstorehouseoutinrecordsForm")
	public String getstorehouseoutinrecordsform(Model model, Map<String, Object> map, String currentPage,
			String recordId, String time, Integer isOut) {
		Integer inCount = 0;// 入库记录条数
		Integer outCount = 0;// 出库记录条数
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

	// 获取出入库详情数据
	@RequestMapping("/storehouseoutindescrecord")
	public String storehouseoutindescrecord(Model model,Long recordId) {
		List<StoreHouseOutInRecord> storeHouseOutInRecord = storeHouseOutInDescRecordService.getStoreHouseOutInRecordById(recordId);
		storeHouseOutInRecord.get(0).setTime(storeHouseOutInRecord.get(0).getTime().substring(0,19));
		model.addAttribute("storeHouse",storeHouseOutInRecord.get(0));
		return "/warehouse/storehouseoutindescrecord";
	}
	
	// 根据条件获取零件或成品出入库详情
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
	
	// ajax添加零件型号
	@RequestMapping("/insertparttype")
	@ResponseBody
	public String insertPartType(PartType partType) {
		Integer result = partTypeService.insertPartType(partType);
		return result.toString();
	}

	// ajax添加成品类别
	@RequestMapping("/insertfinishedproductstype")
	@ResponseBody
	public String insertFinishedProductsType(FinishedProductsType finishedProductsType) {
		Integer result = finishedProductsTypeService.insertFinishedProductsType(finishedProductsType);
		return result.toString();
	}

	// ajax获取采购订单详情信息并使用json返回
	@RequestMapping("/getMaterialDesc")
	@ResponseBody
	public String getMaterialDesc(Long materialId) {
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(materialId);
		// 规范时间格式
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

	// 修改订单签收状态并修改物料表库存数量(收料单)
	@RequestMapping("/updateIsAgreeReceive")
	@ResponseBody
	public String updateIsAgreeReceive(Long id, Long adminId,long releaseDept,long releasePerson,long version, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// 用来格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 存放修改订单签收时的参数
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		map.put("version", version);
		// 获取收料单所含材料
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// 修改领料单审批状态
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////仓库入库数据/////
			////////////////////////
			// 生成入库/出库单号
			long storeId = IDUtil.getId();
			// 出库/入库标志
			Integer isOut = 2;
			// 出入库时间(当前时间)
			String timeNow = sdf.format(new Date());
			// 出入库人
			Admin admin = adminService.getAdmin(adminId.intValue());
			// 出入库人姓名
			String empName = admin.getName();
			// 出入库负责人
			long principal = adminId;
			// 领用人(receivePerson)
			// 领用部门（leadingDept)
			// 存放仓库入库参数
			storeHouseOutInRecord.put("id",storeId);
			storeHouseOutInRecord.put("isOut", isOut);
			storeHouseOutInRecord.put("time", timeNow);
			storeHouseOutInRecord.put("empName", empName);
			storeHouseOutInRecord.put("principal", principal);
			storeHouseOutInRecord.put("releaseDept",releaseDept );
			storeHouseOutInRecord.put("releasePerson",releasePerson);
			
			////////////////////////
			////仓库入库详情数据////
			////////////////////////
			// 创建一个map类型的List用来存储领料单所需材料
			List<Map<String, Object>> hasGoods = new ArrayList<Map<String, Object>>();
			// 先进行材料取出操作
			for (ReceiveCollectMaterialDesc receiveCollectMaterialDesc : materialDescByMaterialList.get(0).getReceiveCollectMaterialDescList()) {
				receiveCollectMaterialDesc.setFinishedPartTypeId(receiveCollectMaterialDesc.getFinishedProductsType().getId());
				if(materialService.getInFinishedProductsStock(receiveCollectMaterialDesc)<=0) {
					return "error";
				}
				// 创建map对象存储所需材料以便进行新增出库详细记录操作
				Map<String, Object> mapTemp = new HashMap<String, Object>();
				// 出库记录ID
				mapTemp.put("outInRecordId", storeId);
				// 所需零件类别
				mapTemp.put("finishedProductId", receiveCollectMaterialDesc.getFinishedPartTypeId());
				// 所需零件数量
				mapTemp.put("num", receiveCollectMaterialDesc.getOrderNum());
				// 结存
				mapTemp.put("goodsOnHand", 0);
				hasGoods.add(mapTemp);
			}
			// 新增出库记录及详情表记录
			if(!storeHouseOutInRecordService.insertStoreHouseOutInRecord(storeHouseOutInRecord, hasGoods)) {
				return "error";
			}
			return "yes";
		} else {
			return "no";
		}
	}
	
	// 修改订单签收状态并修改物料表库存数量(领料单)
	@RequestMapping("/updateIsAgreeById")
	@ResponseBody
	public String updateIsAgreeById(Long id, Long adminId,long leadingDept,long receivePerson,long version, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// 用来格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 存放修改订单签收时的参数
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		map.put("version", version);
		// 获取订单所需材料
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// 修改领料单审批状态
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////仓库出库数据/////
			////////////////////////
			// 生成入库/出库单号
			long storeId = IDUtil.getId();
			// 出库/入库标志
			Integer isOut = 1;
			// 出入库时间(当前时间)
			String timeNow = sdf.format(new Date());
			// 出入库人
			Admin admin = adminService.getAdmin(adminId.intValue());
			// 出入库人姓名
			String empName = admin.getName();
			// 出入库负责人
			long principal = adminId;
			// 领用人(receivePerson)
			// 领用部门（leadingDept)
			// 存放仓库出库参数
			storeHouseOutInRecord.put("id",storeId);
			storeHouseOutInRecord.put("isOut", isOut);
			storeHouseOutInRecord.put("time", timeNow);
			storeHouseOutInRecord.put("empName", empName);
			storeHouseOutInRecord.put("principal", principal);
			storeHouseOutInRecord.put("receivePerson",receivePerson );
			storeHouseOutInRecord.put("leadingDept",leadingDept);
			
			////////////////////////
			////仓库出库详情数据////
			////////////////////////
			// 创建一个map类型的List用来存储领料单所需材料
			List<Map<String, Object>> needGoods = new ArrayList<Map<String, Object>>();
			// 先进行材料取出操作
			for (ReceiveCollectMaterialDesc receiveCollectMaterialDesc : materialDescByMaterialList.get(0).getReceiveCollectMaterialDescList()) {
				if(materialService.getOutMaterials(receiveCollectMaterialDesc)<=0) {
					return "error";
				}
				// 创建map对象存储所需材料以便进行新增出库详细记录操作
				Map<String, Object> mapTemp = new HashMap<String, Object>();
				// 出库记录ID
				mapTemp.put("outInRecordId", storeId);
				// 所需零件类别
				mapTemp.put("partTypeId", receiveCollectMaterialDesc.getPartTypeId());
				// 所需零件数量
				mapTemp.put("num", receiveCollectMaterialDesc.getOrderNum());
				// 结存
				mapTemp.put("goodsOnHand", 0);
				needGoods.add(mapTemp);
			}
			// 新增出库记录及详情表记录
			if(!storeHouseOutInRecordService.insertStoreHouseOutInRecord(storeHouseOutInRecord, needGoods)) {
				return "error";
			}
			return "yes";
		} else {
			return "no";
		}
	}

	// 判断所需材料是否充足(需要查询材料库存表)，不过不足返回缺失的零件名及数量
	@RequestMapping("/comparisonMaterial")
	@ResponseBody
	public String comparisonMaterial(Long materialId) {
		// 获取订单所需材料
		List<ReceiveCollectMaterial> list = receiveCollectMaterialDescService.getMaterialDescByMaterialId(materialId);
		// 获取库存所有材料
		List<Material> allMaterials = materialService.getAllMaterials();
		List<ReceiveCollectMaterialDesc> materialDescList = list.get(0).getReceiveCollectMaterialDescList();
		// 新建一个List用来存储缺少的零件
		List<MissPart> missPartList = new ArrayList<MissPart>();
		for (Material material : allMaterials) {
			for (ReceiveCollectMaterialDesc materialDesc : materialDescList) {
				if (material.getMatType() == materialDesc.getPartType().getId()) {
					if (materialDesc.getOrderNum() > material.getInventoryNum()) {
						// 库存不足
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

	// 采购单审核页面跳转
	@RequestMapping("topurchasetaskaudit")
	public String purchasetaskaudit(Long orderId,Model model) {
		List<PurchaseOrderDesc> purchase = purchaseOrderDescService.getPurchaseOrderDescByOrderId(orderId);
		model.addAttribute("purchase",purchase);
		return "/warehouse/purchasetaskaudit";
	}
	
	// 修改审核状态(审核成功)
	@RequestMapping("updateauditstate")
	@ResponseBody
	public String updateAuditState(String orderId,String auditor,Map<String, Object>map) {
		map.put("id", orderId.substring(3));
		map.put("auditor", auditor);
		Integer result = purchaseOrderService.updateAuditStateId(map);
		return result.toString();
	}
	
	// 修改未通过备注
	@RequestMapping("updatenotpassdesc")
	@ResponseBody
	public String updateNotPassDesc(String orderId,String notPassDesc,Map<String, Object>map) {
		map.put("id",orderId.substring(3));
		map.put("notPassDesc", notPassDesc);
		Integer result = purchaseOrderService.updateNotPassDesc(map);
		return result.toString();
	}
	
	// 跳转到改写采购任务单页
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
	
	// 导出Excel表格
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response,Long shouId,Long lingId) throws Exception {
         //获取数据
         List<ReceiveCollectMaterial> receiveList = null;
         if(shouId!=null && shouId!=0) {
        	 receiveList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(shouId);
	         //excel标题
	         String[] title = {"类别","成品名","数量"};
	         //excel文件名
	         String fileName = System.currentTimeMillis()+".xls";
	         //sheet名
	         String sheetName = "收料单表";
	         String[][] content =  new String[receiveList.get(0).getReceiveCollectMaterialDescList().size()][];
        	 for (int i = 0; i < receiveList.get(0).getReceiveCollectMaterialDescList().size(); i++) {
				 content[i] = new String[title.length];
		         ReceiveCollectMaterialDesc receiveDesc = receiveList.get(0).getReceiveCollectMaterialDescList().get(i);
		         content[i][0] = receiveDesc.getFinishedProductsType().getProductType();
		         content[i][1] = receiveDesc.getFinishedProductsType().getProductName();
		         content[i][2] = receiveDesc.getOrderNum()+"";
	         }
        	//创建HSSFWorkbook 
        	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null,receiveList);
        	
			//响应到客户端
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
	         //excel标题
	         String[] title = {"分类","类别","数量"};
	         //excel文件名
	         String fileName = System.currentTimeMillis()+".xls";
	         //sheet名
	         String sheetName = "领料单表";
	         String[][] content =  new String[receiveList.get(0).getReceiveCollectMaterialDescList().size()][];
        	 for (int i = 0; i < receiveList.get(0).getReceiveCollectMaterialDescList().size(); i++) {
				 content[i] = new String[title.length];
		         ReceiveCollectMaterialDesc receiveDesc = receiveList.get(0).getReceiveCollectMaterialDescList().get(i);
		         content[i][0] = receiveDesc.getPartType().getPartClassify().getPartName();
		         content[i][1] = receiveDesc.getPartType().getPartType();
		         content[i][2] = receiveDesc.getOrderNum()+"";
	         }
        	//创建HSSFWorkbook 
        	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null,receiveList);

			//响应到客户端
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

    // 发送响应流方法
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

    // 判断所需材料是否充足(需要查询成品库存表)，不过不足返回缺失的零件名及数量
    @RequestMapping("/comparisonFinishedPart")
    @ResponseBody
    public String comparisonFinishedPart(long finishedType,long orderNum) {
    	FinishedProductsStock finishedPart = finishedProductsStockService.getFinishedPartById(finishedType);
    	return GsonUtil.GsonString(finishedPart);
    }
    
    // 成品零件出库
    @RequestMapping("/finishedPartOut")
    @ResponseBody
    public String finishedPartOut(Long orderId,Long finishedType,Long orderNum,Long adminId) {
    	try {
    		Map<String, Object> storeHouseOutInRecord = new HashMap<String, Object>();
        	Map<String, Object> storeHouseOutInDescRecordMap = new HashMap<String, Object>();
    		////////////////////////
    		////仓库成品出库数据////
    		////////////////////////
    		// 生成入库/出库单号
    		long storeId = IDUtil.getId();
    		// 出库/入库标志
    		Integer isOut = 1;
    		// 出入库时间(当前时间)
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String timeNow = sdf.format(new Date());
    		// 出入库人
    		Admin admin = adminService.getAdmin(adminId.intValue());
    		// 出入库人姓名
    		String empName = admin.getName();
    		// 出入库负责人
    		long principal = adminId;
    		// 领用人(receivePerson)
    		// 领用部门（leadingDept)
    		// 存放仓库出库参数
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
    		////仓库出库详情数据////
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
    				// 更新成品库存
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

    // 成品库存不足发送生产计划
    @RequestMapping("/sendoutproductionplan")
    @ResponseBody
    public String sendoutproductionplan(Map<String, Object>map,Long finishedProductTypeId,Long produceNum) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	// 生产计划表编号
        	map.put("id","ATC_"+IDUtil.getId());
        	// 成品型号
        	map.put("finishedProductTypeId", finishedProductTypeId);
        	// 生产数量
        	map.put("produceNum",produceNum);
        	// 编写人员
        	map.put("compilers",2);
        	// 下达日期
        	map.put("arrivalTime", sdf.format(new Date()));
        	// 预计完成时间
            Date date=new Date();  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(Calendar.DAY_OF_MONTH, +3);  
            date = calendar.getTime();  
        	map.put("estimatedTimeOfCompletion", date);
        	// 审核状态
        	map.put("auditStateId",1);
        	// 添加生产计划
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