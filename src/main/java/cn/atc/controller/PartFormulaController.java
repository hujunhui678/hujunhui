package cn.atc.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.AdminAndRole;
import cn.atc.common.MissPart;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.PartFormulaDesc;
import cn.atc.pojo.PartType;
import cn.atc.service.MaterialService;
import cn.atc.service.PartClassifyService;
import cn.atc.service.PartFormulaService;
import cn.atc.service.PartTypeService;
import cn.atc.util.DateConverter;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class PartFormulaController {
	@Autowired
	private PartFormulaService partFormulaService;// 成品配方

	@Autowired
	private PartClassifyService partClassifyService; // 零件类别
	
	@Autowired
	private MaterialService materialService; // 库存零件

	@Autowired
	private PartTypeService partTypeService; // 零件类别
	// 跳转编写配方表页面
	@RequestMapping("/SelPartForm")
	public String toPartForm(Model model, @RequestParam(defaultValue = "1") Integer pageIndex, String productName,
			String createTime) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", pageIndex);
		map.put("pageSize", 6);
		map.put("productName", productName);
		map.put("createTime", createTime);
		PageUtil<PartFormula> partFrom = partFormulaService.getAllPartFrom(map);
		model.addAttribute("page", partFrom);
		model.addAttribute("productName", productName);
		model.addAttribute("createTime", createTime);
		return "partformula";
	}

	// 查看指定的配方信息
	@RequestMapping(value = "/getPartForm", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getPartForm(Integer id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pageIndex", 1);
		map.put("pageSize", 6);
		PageUtil<PartFormula> partFrom = partFormulaService.getAllPartFrom(map);
		String json = GsonUtil.GsonString(partFrom.getLists());
		return json;
	}

	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<FinishedProductsType> finish = partFormulaService.getAllFinish();
		model.addAttribute("finish", finish);
		return "partfromula-add";
	}

	@RequestMapping("/addPartFormula")
	@ResponseBody
	public String addPartFormula(PartFormula partFormula, String finishId, String[] PartTypeVals,
			String[] PartClassVals, String[] num) {
		// 首先进行添加配方表
		partFormula.setCreateTime(new java.util.Date());
		Integer result = partFormulaService.addPartFormula(partFormula);
		long newId = partFormula.getId();// 添加成功后的配方表id

		for (int i = 0; i < PartTypeVals.length; i++) {
			// 获得零件类型表信息(根据新添加的配方)
			PartType partType = partFormulaService.getPartType(Integer.parseInt(PartTypeVals[i]));
			// 循环判断 如果没找到此型号对应的零件分类，
			// 则 进行添加操作
			if (partType.getPartClassId() != Integer.parseInt(PartClassVals[i])) {
				PartType pt = new PartType();
				pt.setPartType(partType.getPartType());
				pt.setPartClassId(Long.parseLong(PartClassVals[i]));
				Integer addPartTypeResult = partFormulaService.addPartType(pt);
				if (addPartTypeResult > 0) {// 新的零件分类添加成功 --
					//新增库存零件表
					materialService.insertMater(((Long)pt.getId()).intValue());
					PartFormulaDesc pfd = new PartFormulaDesc();
					pfd.setFinishedProductsTypeId(Long.parseLong(finishId));// 成品id
					pfd.setPartTypeId(pt.getId());
					pfd.setRequirement(Long.parseLong(num[i]));
					pfd.setPartformulaId(newId);
					// 继续进行添加配方详情表信息
					partFormulaService.addPartFormulaDesc(pfd);
				}
			} else {
				// 直接进行添加配方详情表信息
				PartFormulaDesc pfd = new PartFormulaDesc();
				pfd.setFinishedProductsTypeId(Long.parseLong(finishId));// 成品id
				pfd.setPartTypeId(Long.parseLong(PartTypeVals[i]));
				pfd.setRequirement(Long.parseLong(num[i]));
				pfd.setPartformulaId(newId);
				// 继续进行添加配方详情表信息
				partFormulaService.addPartFormulaDesc(pfd);
			}
		}

		// PartType p = new PartType();
		// p.setPartType("1");
		// p.setPartClassId(1);
		// Integer result = partFormulaService.addPartType(p);
		/*
		 * partFormula.setCreateTime(new java.util.Date()); Integer result =
		 * partFormulaService.addPartFormula(partFormula);
		 * System.out.println(partFormula.getId());
		 */
		return "true";
	}

	@RequestMapping("/getPart")
	@ResponseBody
	public String getPartTypeAndClassify() {
		List<PartClassify> classifies = partClassifyService.getAllPartClassifies();
		List<PartType> type = partTypeService.getAllType();
		MissPart mp = new MissPart(classifies, type);
		String partList = GsonUtil.GsonString(mp);
		return partList;
	}

	@RequestMapping("/editState")
	@ResponseBody
	private String editState(String id,Integer state) {
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("id", id);
		maps.put("state", state);
		Integer result = partFormulaService.editState(maps);
		if(result > 0) {
			return "true";
		}
		return "false";
	}
}
