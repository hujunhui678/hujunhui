package cn.atc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.pojo.Admin;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartType;
import cn.atc.pojo.Quality;
import cn.atc.service.AdminService;
import cn.atc.service.FinishedProductsTypeService;
import cn.atc.service.PartTypeService;
import cn.atc.service.QualityService;
import cn.atc.util.PageUtil;
@Controller
@RequestMapping("/page")
public class QualityController {
	
	@Autowired
	private QualityService qualityService;
	
	@Autowired
	private PartTypeService partTypeService;
	
	@Autowired
	private FinishedProductsTypeService finishedproductstypeService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/quality")
	public String list(Model model,@RequestParam(defaultValue="0")int deptNo,String currentPage,
			String partType,String name,String state){
		int temp=1;
		if(currentPage!=null && !currentPage.trim().equals("")){
			temp=Integer.parseInt(currentPage);
		}
		PageUtil<Quality> page=qualityService.queryAll(deptNo,partType,name,state,temp, 6);
		List<PartType> partTypes=partTypeService.getAllType();
		List<FinishedProductsType> finishedproductstypes=finishedproductstypeService.getFinishedproductstype();
		List<Admin> admins=adminService.queryAll();
		model.addAttribute("page", page);
		model.addAttribute("deptNo",deptNo);
		model.addAttribute("partType", partType);
		model.addAttribute("name", name);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("partTypes", partTypes);
		model.addAttribute("state", state);
		model.addAttribute("admins", admins);
		model.addAttribute("finishedproductstypes", finishedproductstypes);
		return "quality";
	}
	
	
	@RequestMapping("/doadd")
	public String doAdd(Model model,@RequestParam(defaultValue="0")int detectionPartTypeId,
			@RequestParam(defaultValue="1")int detectionFinishedTypeId) throws Exception{
		List<PartType> partTypes=partTypeService.getAllType();
		List<FinishedProductsType> finishedproductstypes=finishedproductstypeService.getFinishedproductstype();
		List<Admin> admins=adminService.queryAll();
		model.addAttribute("detectionPartTypeId", detectionPartTypeId);
		model.addAttribute("detectionFinishedTypeId", detectionFinishedTypeId);
		
		model.addAttribute("admins", admins);
		model.addAttribute("partTypes", partTypes);
		model.addAttribute("finishedproductstypes", finishedproductstypes);
		return "quality_Add";
	}
	
	@RequestMapping(value="/toadd",method=RequestMethod.POST)
	@ResponseBody
	public String toAdd( Model model,Quality quality,String subTime
			) throws Exception{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date submiDate = sdf.parse(subTime);
		quality.setSubmissionTime(submiDate);
		int result=qualityService.addQuality(quality);
		if(result>0) {	
			return "true";
		}else {
		
			return "false";
		}
	}
	
	@RequestMapping("/doupdate")
	
	public String doupdate(Model model,int id) throws Exception{
		Quality quality=qualityService.getQualityId(id);
		List<PartType> partTypes=partTypeService.getAllType();
		List<FinishedProductsType> finishedproductstypes=finishedproductstypeService.getFinishedproductstype();
		List<Admin> admins=adminService.queryAll();
		model.addAttribute("admins", admins);
		model.addAttribute("partTypes", partTypes);
		model.addAttribute("finishedproductstypes", finishedproductstypes);
		model.addAttribute("id", id);
		model.addAttribute("quality", quality);
		
		return "quality_modify";
		
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public String toupdate(Model model,Quality quality) throws Exception{
		Integer result=qualityService.updateQuality(quality);
		if(result>0) {
			return "true";
		}else {
			return "false";
		}
		
		
	}
	
	@RequestMapping("/doDelete")
	@ResponseBody
	public String delete(Model model,int id) throws Exception{
		int result=qualityService.deleteQuality(id);
		
		if(result>0) {
			return "ok";
		}else {
			return "on";
		}
	
	}
}
