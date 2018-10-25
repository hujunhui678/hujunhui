package cn.atc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import cn.atc.common.ProplanAndFormula;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.service.PartFormulaService;
import cn.atc.service.ProductionPlanService;
import cn.atc.service.ReceiveCollectMaterialDescService;
import cn.atc.service.ReceiveCollectMaterialService;
import cn.atc.util.DateConverter;
import cn.atc.util.GsonUtil;
import cn.atc.util.IDUtil;
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
		System.out.println(allProPlan.getLists().get(0).getImageUrl());
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
	public String toAdd(@RequestParam(defaultValue = "0") Integer id, String saveFinishId, String saveNum,
			Model model) {
		// ������еĿ��ó�Ʒ�ͺ�
		List<FinishedProductsType> finish = pfs.getAllFinish();
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", 1);
		map.put("pageSize", 99);
		map.put("state", "0");
		// ������е��䷽
		PageUtil<PartFormula> page = pfs.getAllPartFrom(map);
		model.addAttribute("finish", finish);
		model.addAttribute("page", page);
		if (id > 0) {
			map.put("id", id);
			PageUtil<PartFormula> partFrom = pfs.getAllPartFrom(map);
			model.addAttribute("PartForm", partFrom.getLists());
			model.addAttribute("saveFinishId", saveFinishId);
			model.addAttribute("saveNum", saveNum);
			model.addAttribute("id", id);
		}
		return "Proplan-add";
	}

	@RequestMapping("/bingFormula")
	@ResponseBody
	public String bingFormula(String id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", 1);
		map.put("pageSize", 99);
		map.put("state", "0");
		// ������е��䷽
		PageUtil<PartFormula> page = pfs.getAllPartFrom(map);
		List<PartFormula> pfList = page.getLists();
		// ��ĳ����Ʒ���䷽
		PartFormula formula = pfs.getPFByid(id);
		ProplanAndFormula paf = new ProplanAndFormula(pfList, formula);
		String gson = GsonUtil.GsonString(paf);
		return gson;
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("fileImage") MultipartFile[] fileImage, ProductionPlan pp, Model model,
			HttpServletRequest request) {
		Date date = DateConverter.getSqlDate();// ��ǰʱ��
		// ��ȡ������ʱ��
		String id = "ATC_" + IDUtil.getId();
		Date dateAfterThree = DateConverter.getDateAfter(date, 3);
		String picPath = "";
		if (fileImage != null && fileImage.length > 0) {
			// 1.��÷������������洢ͼƬ���ļ���·��
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "images" + File.separator + "upload");
			for (int i = 0; i < fileImage.length; i++) {
				MultipartFile mult = fileImage[i];
				if (!mult.isEmpty()) {
					// 2.����ϴ��ļ�������
					String oldName = mult.getOriginalFilename();// �涨�ϴ�jpg�ļ�
					if (oldName.endsWith(".jpg")) {
						// �ļ��ϴ�
						// 1.���¶���һ���ļ���
						String newName = IDUtil.genImageName() + oldName;
						// �������˽���
						File file = new File(path, newName);
						picPath = File.separator + "statics" + File.separator + "images" + File.separator + "upload"
								+ File.separator + newName;// ·��
						try {
							mult.transferTo(file);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						model.addAttribute("msg", "�ļ����ʹ���,��ѡ��JPG�ļ�~");
						return "forward:toAddForProplan";
					}
				}
			}
		}
		pp.setId(id);
		pp.setArrivalTime(date);

		pp.setEstimatedTimeOfCompletion(dateAfterThree);
		pp.setImageUrl(picPath);
		Integer result = pps.insertProplan(pp);
		if (result > 0) {
			model.addAttribute("addResult", "T");
			return "forward:toAddForProplan";
		} else {
			model.addAttribute("addResult", "F");
			return "forward:toAddForProplan";
		}
	}

	@RequestMapping(value = "/getProplan", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getProplan(String id) {
		// ������еĳ�Ʒ�ͺ�
		List<FinishedProductsType> fptList = pfs.getAllFinish();
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("pageIndex", 1);
		maps.put("id", id);
		maps.put("pageSize", 99);
		// �����ƻ�
		PageUtil<ProductionPlan> allProPlan = pps.getAllProPlan(maps);
		ProductionPlan pp = allProPlan.getLists().get(0);
		pp.setId(id);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageIndex", 1);
		map.put("pageSize", 99);
		map.put("state", "0");
		// ������е��䷽
		PageUtil<PartFormula> page = pfs.getAllPartFrom(map);
		List<PartFormula> pfList = page.getLists();
		// ���ʹ�õ��䷽
		List<ProductionPlan> partFromula = pps.getPartFromulaById(id);
		PartFormula partFormula = partFromula.get(0).getPartFormula();
		ProplanAndFormula paf = new ProplanAndFormula(fptList, pfList, partFormula, pp);
		String json = GsonUtil.GsonString(paf);
		return json;
	}

	@RequestMapping("/editProplan")
	@ResponseBody
	public String editProplan(ProductionPlan pp) {
		Integer result = pps.editProplan(pp);
		if (result > 0) {
			return "true";
		}
		return "false";
	}
}
