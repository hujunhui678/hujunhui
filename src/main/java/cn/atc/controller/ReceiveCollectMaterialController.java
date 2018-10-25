
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

	// �������ϵ�
	@RequestMapping("/addReveice")
	@ResponseBody
	public String addReveice(String[] partIds, String[] Requirements, String adminId, Model model) {
		ReceiveCollectMaterial rcm = new ReceiveCollectMaterial();
		// �������ϵ�����...
		long id = IDUtil.getId();// ���ϵ���id;
		rcm.setId(id);
		rcm.setIsReceive(2);// 2�������ϵ�
		rcm.setProposerId(Long.parseLong(adminId));// �����˵�id
		rcm.setReleaseTime(DateConverter.getDate());// ��ȡ��ǰʱ��
		Integer result = rcms.insertReceive(rcm);
		if (result > 0) {// �����ɹ�---��ʼ�����������������
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

	// ����������ϵ�
	// �鿴�������ϵ�..
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

	// ת�����ҳ��
	@RequestMapping("/goAuditReceive")
	public String goAuditReceive(String id, Model model) {
		List<ReceiveCollectMaterial> list = rcmds.getMaterialDescByMaterialId(Long.parseLong(id));
		model.addAttribute("Receive", list.get(0).getReceiveCollectMaterialDescList());
		model.addAttribute("id", id);
		return "AuditStateReceive";
	}

	// ���ϵ��������
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
