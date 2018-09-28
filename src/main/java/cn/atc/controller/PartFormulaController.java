package cn.atc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.AdminAndRole;
import cn.atc.pojo.PartFormula;
import cn.atc.service.PartFormulaService;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class PartFormulaController {
	@Autowired
	private PartFormulaService partFormulaService;

	// 跳转编写配方表页面
	@RequestMapping("/SelPartForm")
	public String toPartForm(Model model, @RequestParam(defaultValue = "1") Integer pageIndex, String productName,
			String createTime) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", pageIndex);
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
		PageUtil<PartFormula> partFrom = partFormulaService.getAllPartFrom(map);
		String json = GsonUtil.GsonString(partFrom.getLists());
		return json;
	}
}
