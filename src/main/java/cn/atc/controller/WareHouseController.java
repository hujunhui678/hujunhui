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
	private ReceiveCollectMaterialService receiveCollectMaterialService;// 收领料单
	
	@Autowired
	private ReceiveCollectMaterialDescService receiveCollectMaterialDescService;// 收领料单详情

	// 跳转到出库入库管理页
	@RequestMapping("/outInwarehouse")
	public String outwareHouse() {
		return "forward:getstorehouseoutinrecordsForm";
	}

	// 跳转到领料单页面
	@RequestMapping(value = "/materialmanage")
	public String materialmanage(Model model, Map<String, Object> map, String partType, String auditStateId,
			String materialId, String releaseTime, String currentPage, String totalPage,@RequestParam(value="isReceive",required=false,defaultValue="2")Integer isReceive) {
		map.put("isReceive", isReceive);
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
		model.addAttribute("inCount", inCount);
		model.addAttribute("outCount", outCount);
		model.addAttribute("page", page);
		model.addAttribute("recordId", recordId);
		model.addAttribute("time", time);
		model.addAttribute("isOut", isOut);
		return "/warehouse/outinwarehouse";
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

	// 修改订单签收状态并修改物料表库存数量
	@RequestMapping("/updateIsAgreeById")
	@ResponseBody
	public String updateIsAgreeById(Long id, Long adminId,long leadingDept,long receivePerson, Map<String, Object> map,Map<String, Object> storeHouseOutInRecord) {
		// 用来格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 存放修改订单签收时的参数
		map.put("id", id);
		map.put("isAgree",1);
		map.put("adminId", adminId);
		// 获取订单所需材料
		List<ReceiveCollectMaterial> materialDescByMaterialList = receiveCollectMaterialDescService.getMaterialDescByMaterialId(id);
		// 修改领料单审批状态
		Integer result = receiveCollectMaterialService.updateIsAgreeById(map);
		if (result > 0) {
			////////////////////////
			///////仓库出库数据/////
			////////////////////////
			// 四位随机数获取
			Integer numFour=(int)(Math.random()*8999)+1000;
			// 固定格式时间获取
			SimpleDateFormat sdfId = new SimpleDateFormat("yyyyMMddHHmm");
			String time = sdfId.format(new Date());
			// 生成入库/出库单号
			long storeId = Long.parseLong(numFour.toString()+time);
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

}