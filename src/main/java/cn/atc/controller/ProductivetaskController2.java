package cn.atc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.atc.pojo.Admin;
import cn.atc.pojo.PartType;
import cn.atc.pojo.Productivetask2;
import cn.atc.service.AdminService;
import cn.atc.service.*;
import cn.atc.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/page")
public class ProductivetaskController2 {
	@Autowired
	private PartTypeService parttypeService;
	@Autowired
	private ProductiveTaskService productiveTaskService;
	@Autowired
	private ProductionPlanService productionplanService;
	@Autowired
	private AdminService adminService;

	//灞曠ず鐢熶骇浠诲姟涔�
//	@RequestMapping("/productive")
//	public String list(Model model,
//			Map<String, Object> map,Integer currentPage) {
//		if(currentPage==null||currentPage<1) {
//			currentPage=1;
//		}
//		map.put("pageIndex", currentPage);
//		List<PartType> partTypes=parttypeService.queryAll();
//		PageUtil<Productivetask2> productivetask = productiveTaskService.getProductivetask(map);
//		List<Admin>admin=adminService.queryAll();
//		PageUtil<Productivetask2> page=null;
//		page=productiveTaskService.getProductivetask(map);
//		model.addAttribute("page", page);
//		model.addAttribute("pageIndex", currentPage);
//		model.addAttribute("partTypes", partTypes);
//		model.addAttribute("productionplan", productivetask);
//		model.addAttribute("admin", admin);
//		return "productive";
//	}

	//杩涘叆鐢熶骇浠诲姟涔︽坊鍔犵晫闈�
	@RequestMapping(value = "/toAddProductive", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String toAddPerson(String url) throws Exception {
		return null;
	}

	/**
	 * 娣诲姞鐢熶骇浠诲姟涔�
	 * @param productivetask
	 * @return true | false
	 */
//	@RequestMapping(value = "/addProductivetask",method = RequestMethod.POST)
//	@ResponseBody
//	public String addProductivetask(@RequestBody Productivetask2 productivetask){
//		return String.valueOf(productiveTaskService.addProductiveTask(productivetask));
//	}

	/**
	 * 淇敼鐢熶骇浠诲姟涔�
	 * @param productivetask
	 * @return true | false
	 */
//	@RequestMapping("/updateProductivetask")
//	@ResponseBody
//	public String updateProductivetask(Productivetask2 productivetask) {
//		return String.valueOf(productiveTaskService.updateProductivetask(productivetask));
//	}

	/**
	 * 鍒犻櫎(鍖呮嫭鎵归噺鍒犻櫎)鐢熶骇浠诲姟涔�
	 * @param ids
	 * @return true | false
	 */
//	@RequestMapping("/delProductivetask")
//	@ResponseBody
//	public String delProductivetask(String[] ids) {
//		return String.valueOf(productiveTaskService.deleteProductiveTask(ids));
//	}

}
