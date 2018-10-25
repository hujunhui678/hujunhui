
package cn.atc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.service.ReceiveCollectMaterialDescService;
import cn.atc.service.ReceiveCollectMaterialService;
import cn.atc.util.DateConverter;
import cn.atc.util.GsonUtil;
import cn.atc.util.IDUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class ReceiveCollectMaterialController {

	@Autowired
	private ReceiveCollectMaterialService rcms;
	@Autowired
	private ReceiveCollectMaterialDescService rcmds;

	// 新增领料单
	@RequestMapping("/addReveice")
	@ResponseBody
	public String addReveice(String[] partIds, String[] Requirements, String adminId, Model model) {
		ReceiveCollectMaterial rcm = new ReceiveCollectMaterial();
		// 新增领料单操作...
		long id = IDUtil.getId();// 领料单的id;
		rcm.setId(id);
		rcm.setIsReceive(2);// 2代表领料单
		rcm.setProposerId(Long.parseLong(adminId));// 申请人的id
		rcm.setReleaseTime(DateConverter.getDate());// 获取当前时间
		Integer result = rcms.insertReceive(rcm);
		if (result > 0) {// 新增成功---开始新增领料详情表数据
			List<ReceiveCollectMaterialDesc> rcmdList = new ArrayList<>();
			for (int i = 0; i < partIds.length; i++) {
				ReceiveCollectMaterialDesc rcmd = new ReceiveCollectMaterialDesc();
				rcmd.setMaterialId(rcm.getId());
				rcmd.setPartTypeId(Long.parseLong(partIds[i]));
				rcmd.setOrderNum(Long.parseLong(Requirements[i]));
				rcmdList.add(rcmd);
			}
			Integer DescResult = rcmds.insertReceiveDesc(rcmdList);
			if (DescResult > 0) {
				return "true";
			}
		}
		return "false";
	}

	// 主管审核领料单
	// 查看所有领料单..
	@RequestMapping("/goReceive")
	public String goReceive(String currentPage, @RequestParam(defaultValue = "") String propose,
			@RequestParam(defaultValue = "") String arrivalTime, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("isReceive", 2);
		map.put("currentPage", currentPage);
		map.put("propose", propose);
		map.put("releaseTime", arrivalTime);
		PageUtil<ReceiveCollectMaterial> page = rcms.getReceiveCollectMaterialByCondition(map);
		model.addAttribute("page", page);
		model.addAttribute("propose", propose);
		model.addAttribute("arrivalTime", arrivalTime);
		return "receive";
	}

	// 转到审核页面
	@RequestMapping("/goAuditReceive")
	public String goAuditReceive(String id, Model model) {
		List<ReceiveCollectMaterial> list = rcmds.getMaterialDescByMaterialId(Long.parseLong(id));
		model.addAttribute("Receive", list.get(0).getReceiveCollectMaterialDescList());
		model.addAttribute("id", id);
		return "AuditStateReceive";
	}

	// 领料单进行审核
	@RequestMapping("/AuditReceive")
	@ResponseBody
	public String AuditReceive(ReceiveCollectMaterial rcm, Model model) {
		rcm.setAuditTime(DateConverter.getDate());
		Integer result = rcms.auditReceive(rcm);
		if (result > 0) {
			return "true";
		}
		return "false";
	}

	@RequestMapping(value = "/getAuditToReceive", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getAudit(String id, Model model) {
		ReceiveCollectMaterial rcm = rcms.getReason(id);
		String data = GsonUtil.GsonString(rcm);
		return data;
	}

	@RequestMapping("/delReveice")
	@ResponseBody
	public String delReveice(String id) {
		Integer result = rcms.delReveive(id);
		if (result > 0) {
			return "true";
		}
		return "false";
	}
	

}
