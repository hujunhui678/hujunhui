package cn.atc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.mapper.AdminMapper;
import cn.atc.pojo.Admin;
import cn.atc.util.MD5Util;

@Controller
@RequestMapping("/page")
public class CommonController {
	@Autowired
	private AdminMapper adminMapper;

	// 获得要修改管理员资料
	@RequestMapping("/modifyData.html")
	public String modifyData(Model model, Integer id) {
		Admin admin = adminMapper.getAdmin(id);
		Integer count = adminMapper.getAdminByLoginNameModifyCount(id);
		model.addAttribute("admin", admin);
		model.addAttribute("count", count);
		model.addAttribute("id", id);
		return "modifyData";
	}

	// 修改管理员资料
	@RequestMapping("/modifyAdminData.html")
	@ResponseBody
	public String modifyAdminData(Admin admin) {
		Integer result = adminMapper.updateAdmin(admin);
		if (result > 0) {
			return "ok";
		}
		return "no";
	}

	// 获得该管理员的旧密码
	@RequestMapping("/getOldPwd.html")
	@ResponseBody
	public String getOldPwd(Integer id, String pwd) {
		Admin admin = adminMapper.getAdmin(id);
		if (MD5Util.verify(pwd, admin.getPassword())) {
			return "ok";
		}
		return "no";
	}

	@RequestMapping("updatePwd.html")
	@ResponseBody
	public boolean updatePwd(Admin admin) {
		String old = admin.getPassword();
		admin.setPassword(MD5Util.generate(old));
		Integer result = adminMapper.updatePwd(admin);
		if (result > 0) {
			return true;
		}
		return false;
	}
}
