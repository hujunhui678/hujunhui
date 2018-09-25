package cn.atc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.atc.common.AdminAndRole;
import cn.atc.common.EmpAndRole;
import cn.atc.pojo.Admin;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;
import cn.atc.service.ChildDeptService;
import cn.atc.service.PersonService;
import cn.atc.service.RoleService;
import cn.atc.util.DateConverter;
import cn.atc.util.GsonUtil;
import cn.atc.util.MD5Util;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ChildDeptService childDeptService;

	// 展示人员列表
	@RequestMapping("/person")
	public String getRole(@RequestParam(defaultValue = "管理员") String sel, Model model, Map<String, Object> map,
			Integer currentPage) {

		if (currentPage == null || currentPage < 1) {
			currentPage = 1;
		}
		map.put("pageIndex", currentPage);
		PageUtil<Admin> page = null;
		if (sel.equals("管理员")) {
			// 管理员
			page = personService.getAllAdmin(map);
		} else if (sel.equals("雇员")) {
			// 雇员
			page = personService.getAllEmp(map);
		}
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", currentPage);
		model.addAttribute("sel", sel);
		return "person";
	}

	// 进入人员添加页面
	@RequestMapping(value = "/toAddPerson", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String toAddPerson(String url) throws Exception {
		AdminAndRole adminAndRole = new AdminAndRole(roleService.getRole(), childDeptService.getChildDept());
		String json = GsonUtil.GsonString(adminAndRole);
		return json;
	}

	// 手机号查重
	@RequestMapping("/selPhone")
	@ResponseBody
	public String selPhone(String phone) {
		Integer count = personService.getAdminPhone(phone.trim());
		if (count >= 1) {
			return "false";
		} else {
			return "true";
		}
	}

	// 添加管理员
	@RequestMapping("/addPerson")
	@ResponseBody
	public String addAdmin(String isPerson, String[] roles, Admin admin) throws Exception {
		admin.setLoginName(admin.getPhone());// 默认手机号为登录号
		admin.setPassword(MD5Util.generate("123"));// 默认密码为123
		admin.setEntryTime(DateConverter.getNowDateShort());//入职时间
		Integer count = personService.addAdmin(admin);
		if (count >= 1 && roles.length > 0) {
			// 插入管理员角色表
			Integer adminId = personService.getAdminIdByPhone(admin.getPhone());
			if (adminId != null) {
				Map<String, Object> maps = new HashMap<String, Object>();
				maps.put("roles", roles);
				maps.put("id", adminId);
				Integer role = roleService.addRole(maps);
				return "true";
			}
		} else if (count >= 1) {
			return "true";
		}
		return "false";
	}

	// 添加雇员
	@RequestMapping("/addEmp")
	@ResponseBody
	public String addEmp(Employee employee) {
		Integer result = personService.addEmp(employee);
		if (result > 0) {
			return "true";
		}
		return "false";
	}

	// 获得要修改管理员的信息
	@RequestMapping("/toEditPerson")
	@ResponseBody
	public String toEditPerson(String isPerson, Integer id) {
		AdminAndRole adminAndRole = new AdminAndRole(roleService.getRole(), childDeptService.getChildDept(),
				personService.getAdminAllRole(id), personService.getAdminNameAndChildDept(id));
		String json = GsonUtil.GsonString(adminAndRole);
		return json;
	}

	// 获得要修改雇员的信息
	@RequestMapping("/toEditEmp")
	@ResponseBody
	public String toEditEmp(String isPerson, Integer id) {
		EmpAndRole ear = new EmpAndRole(childDeptService.getChildDept(), personService.getEmpAndChildDept(id));
		String json = GsonUtil.GsonString(ear);
		return json;
	}

	// 修改管理员
	@RequestMapping("/editPerson")
	@ResponseBody
	public String editPerson(String[] roles, Admin admin) {
		// 修改管理员的信息
		Integer editAdmin = personService.updateAdmin(admin);
		if (editAdmin > 0) {
			// 删除其下所有角色，重新插入
			Integer delResult = personService.delAdminRole((int) admin.getId());
			if (delResult > 0) {
				Map<String, Object> maps = new HashMap<String, Object>();
				maps.put("roles", roles);
				maps.put("id", admin.getId());
				Integer role = roleService.addRole(maps);
				return "true";
			}
		}
		return "false";
	}

	// 修改雇员
	@RequestMapping("/editEmp")
	@ResponseBody
	public String editEmp(Employee employee) {
		Integer editAdmin = personService.updateEmp(employee);
		if (editAdmin > 0) {
			return "true";
		}
		return "false";
	}

	// 删除操作 --> 管理员或雇员
	@RequestMapping("/delPerson")
	@ResponseBody
	public String delAdmin(String[] ids, String isPerson, Model model) {
		String result = "no";
		Integer delResult = 0;
		if (isPerson.equals("管理员")) {
			for (String id : ids) {
				// 先删除此管理员对应的所有角色信息。
				personService.delAdminRole(Integer.parseInt(id));
			}
			delResult = personService.delAdmin(ids);
		} else {
			delResult = personService.delEmp(ids);
		}
		if (delResult > 0) {
			result = "ok";
		}
		return result;
	}

}
