package cn.atc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.ProductionPlan;
import cn.atc.service.PartFormulaService;
import cn.atc.service.ProductionPlanService;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class ProductionPlanController {

	@Autowired
	private ProductionPlanService pps;
	@Autowired
	private PartFormulaService pfs;

	@RequestMapping("/technical")
	public String SelTechnincal(Model model, @RequestParam(defaultValue = "1") Integer pageIndex, String productName,
			String arrivalTime) {
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("pageIndex", pageIndex);
		maps.put("productName", productName);
		maps.put("arrivalTime", arrivalTime);
		PageUtil<ProductionPlan> allProPlan = pps.getAllProPlan(maps);
		model.addAttribute("page", allProPlan);
		model.addAttribute("productName", productName);
		model.addAttribute("arrivalTime", arrivalTime);
		model.addAttribute("pageIndex", pageIndex);
		return "technical";
	}

	@RequestMapping("/toAudit")
	public String toAudit(String id, Model model) {
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("pageIndex", 1);
		maps.put("id", id);
		PageUtil<ProductionPlan> allProPlan = pps.getAllProPlan(maps);
		model.addAttribute("ProPlan", allProPlan.getLists().get(0));
		List<ProductionPlan> partFromula = pps.getPartFromulaById(id);
		model.addAttribute("PartForm", partFromula);
		model.addAttribute("id", id);
		model.addAttribute("formulaName", partFromula.get(0).getPartFormula().getFormulaName());
		return "AuditStateProPlan";
	}

	@RequestMapping("/audit")
	@ResponseBody
	public String auditString(String id, String ison, String reason) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("auditStateId", ison);
		map.put("reason", reason);
		Integer result = pps.ProductionPlanGoAudit(map);
		if (result > 0) {
			return "true";
		}
		return "false";
	}

	@RequestMapping(value = "/getAudit", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getAudit(String id, Model model) {
		ProductionPlan plan = pps.getReason(id);
		String data = GsonUtil.GsonString(plan);
		return data;
	}

	@RequestMapping("/toAddForProplan")
	public String toAdd(@RequestParam(defaultValue = "0") Integer id,String saveFinishId,String saveNum, Model model) {
		// 获得所有的成品型号
		List<FinishedProductsType> finish = pfs.getAllFinish();
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", 1);
		// 获得所有的配方
		PageUtil<PartFormula> page = pfs.getAllPartFrom(map);
		model.addAttribute("finish", finish);
		model.addAttribute("page", page);
		if (id > 0) {
			map.put("id", id);
			PageUtil<PartFormula> partFrom = pfs.getAllPartFrom(map);
			model.addAttribute("PartForm", partFrom.getLists());
			model.addAttribute("saveFinishId",saveFinishId);
			model.addAttribute("saveNum", saveNum);
			model.addAttribute("id", id);
		}
		return "Proplan-add";
	}

	@RequestMapping("/getFormDesc")
	public String getDesc(String id, Model model) {

		return "";
	}
}
