package cn.atc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Role;
import cn.atc.service.RoleService;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class MainController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/goMain")
	public String LoginSuccess() {
		return "atcMain";
	}

	@RequestMapping("/loginout")
	public String loginOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login.jsp";
	}

	// 角色数据获取
	@RequestMapping("/role")
	public String getRole(Model model, Map<String, Object> map, Integer currentPage) {
		if (currentPage == null || currentPage < 1) {
			currentPage = 1;
		}
		map.put("currentPage", currentPage);
		map.put("pageSize", 3);
		PageUtil<Role> page = roleService.getAdminAndRoles(map);
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", currentPage);
		return "role";
	}

	// 权限数据获取
	@RequestMapping("/perm")
	public String getPerm() {
		return "atcMain";
	}

	// 角色名查重
	@RequestMapping("/chachong")
	@ResponseBody
	public String chaChong(String roleName) {
		Integer count = roleService.getCountByRoleName(roleName.trim());
		if (count >= 1) {
			return "false";
		} else {
			return "true";
		}
	}

	// 添加角色
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(Role role) {
		Integer addResult = roleService.addRole(role);
		return addResult.toString();
	}

	// 查询要修改的角色信息
	@RequestMapping("/getRoleById")
	@ResponseBody
	public String getRoleById(Integer id) {
		Role role = roleService.getRoleById(id);
		return GsonUtil.GsonString(role);
	}

	// 修改角色信息
	@RequestMapping("/updateRole")
	@ResponseBody
	public String updateRole(Role role) {
		Integer result = roleService.updateRole(role);
		return result.toString();
	}

	// 删除角色信息
	@RequestMapping("/delRole")
	@ResponseBody
	public String delRole(String[] ids,Model model) {
		// 批量删除角色
		Integer delResult = 0;
		String result = "";
		try {
			delResult = roleService.delRole(ids);
		} catch (Exception e) {
			result = "error";
		}
		
		if (delResult > 0) {
			result = "ok";
		}
		return result;
	}

}
