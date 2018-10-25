package cn.atc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.mapper.AdminMapper;
import cn.atc.mapper.LogMapper;
import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.pojo.ProductionPlan;
import cn.atc.service.AdminService;
import cn.atc.service.LogService;
import cn.atc.service.ProductionPlanService;
import cn.atc.util.MD5Util;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class CommonController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private LogService loginService;
	@Autowired
	private ProductionPlanService pps;

	// 获得要修改管理员资料
	@RequestMapping("/modifyData.html")
	public String modifyData(Model model, Integer id, @RequestParam(defaultValue = "1") String pageIndex) {
		Admin admin = adminService.getAdmin(id);
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("pageIndex", pageIndex);
		maps.put("loginName", admin.getLoginName());
		PageUtil<LoginLog> allLog = loginService.getAllLog(maps);
		Integer count = adminService.getAdminByLoginNameModifyCount(id);
		model.addAttribute("admin", admin);
		model.addAttribute("count", count);
		model.addAttribute("id", id);
		model.addAttribute("loginLog", allLog);
		return "modifyData";
	}

	// 修改管理员资料
	@RequestMapping("/modifyAdminData.html")
	@ResponseBody
	public String modifyAdminData(Admin admin) {
		Integer result = adminService.updateAdmin(admin);
		if (result > 0) {
			return "ok";
		}
		return "no";
	}

	// 获得该管理员的旧密码
	@RequestMapping("/getOldPwd.html")
	@ResponseBody
	public String getOldPwd(Integer id, String pwd) {
		Admin admin = adminService.getAdmin(id);
		if (MD5Util.verify(pwd, admin.getPassword())) {
			return "ok";
		}
		return "no";
	}

	@RequestMapping("updatePwd.html")
	@ResponseBody
	public String updatePwd(Admin admin) {
		String old = admin.getPassword();
		admin.setPassword(MD5Util.generate(old));
		Integer result = adminService.updatePwd(admin);
		if (result > 0) {
			return "true";
		}
		return "false";
	}

	// 获取所有的登录日志
	@RequestMapping("/logList")
	public String logList(Model model, @RequestParam(defaultValue = "1") String pageIndex, String name,
			String loginTime) {
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("pageIndex", pageIndex);
		maps.put("name", name);
		maps.put("loginTime", loginTime);
		PageUtil<LoginLog> allLog = loginService.getAllLog(maps);
		model.addAttribute("page", allLog);
		model.addAttribute("name", name);
		model.addAttribute("loginTime", loginTime);
		return "LoginLog";
	}

	// 删除几天前的日志数据
	@RequestMapping("/delLog")
	@ResponseBody
	public String delLog(Integer day) {
		try {
			Integer result = loginService.delLog(day);
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "ok";
	}

	// 获取要导出的数据
	@RequestMapping("/toPort")
	public String toPort(String[] ids,Model model) {
		List<ProductionPlan> plan = pps.getProPlan(ids);
		model.addAttribute("plan", plan);
		return "ExportExcel";
	}

}
