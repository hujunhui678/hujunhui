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

	// չʾ��Ա�б�
	@RequestMapping("/person")
	public String getRole(@RequestParam(defaultValue = "����Ա") String sel, Model model, Map<String, Object> map,
			Integer currentPage) {

		if (currentPage == null || currentPage < 1) {
			currentPage = 1;
		}
		map.put("pageIndex", currentPage);
		PageUtil<Admin> page = null;
		if (sel.equals("����Ա")) {
			// ����Ա
			page = personService.getAllAdmin(map);
		} else if (sel.equals("��Ա")) {
			// ��Ա
			page = personService.getAllEmp(map);
		}
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", currentPage);
		model.addAttribute("sel", sel);
		return "person";
	}

	// ������Ա���ҳ��
	@RequestMapping(value = "/toAddPerson", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String toAddPerson(String url) throws Exception {
		AdminAndRole adminAndRole = new AdminAndRole(roleService.getRole(), childDeptService.getChildDept());
		String json = GsonUtil.GsonString(adminAndRole);
		return json;
	}

	// �ֻ��Ų���
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

	// ��ӹ���Ա
	@RequestMapping("/addPerson")
	@ResponseBody
	public String addAdmin(String isPerson, String[] roles, Admin admin) throws Exception {
		admin.setLoginName(admin.getPhone());// Ĭ���ֻ���Ϊ��¼��
		admin.setPassword(MD5Util.generate("123"));// Ĭ������Ϊ123
		admin.setEntryTime(DateConverter.getNowDateShort());//��ְʱ��
		Integer count = personService.addAdmin(admin);
		if (count >= 1 && roles.length > 0) {
			// �������Ա��ɫ��
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

	// ��ӹ�Ա
	@RequestMapping("/addEmp")
	@ResponseBody
	public String addEmp(Employee employee) {
		Integer result = personService.addEmp(employee);
		if (result > 0) {
			return "true";
		}
		return "false";
	}

	// ���Ҫ�޸Ĺ���Ա����Ϣ
	@RequestMapping("/toEditPerson")
	@ResponseBody
	public String toEditPerson(String isPerson, Integer id) {
		AdminAndRole adminAndRole = new AdminAndRole(roleService.getRole(), childDeptService.getChildDept(),
				personService.getAdminAllRole(id), personService.getAdminNameAndChildDept(id));
		String json = GsonUtil.GsonString(adminAndRole);
		return json;
	}

	// ���Ҫ�޸Ĺ�Ա����Ϣ
	@RequestMapping("/toEditEmp")
	@ResponseBody
	public String toEditEmp(String isPerson, Integer id) {
		EmpAndRole ear = new EmpAndRole(childDeptService.getChildDept(), personService.getEmpAndChildDept(id));
		String json = GsonUtil.GsonString(ear);
		return json;
	}

	// �޸Ĺ���Ա
	@RequestMapping("/editPerson")
	@ResponseBody
	public String editPerson(String[] roles, Admin admin) {
		// �޸Ĺ���Ա����Ϣ
		Integer editAdmin = personService.updateAdmin(admin);
		if (editAdmin > 0) {
			// ɾ���������н�ɫ�����²���
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

	// �޸Ĺ�Ա
	@RequestMapping("/editEmp")
	@ResponseBody
	public String editEmp(Employee employee) {
		Integer editAdmin = personService.updateEmp(employee);
		if (editAdmin > 0) {
			return "true";
		}
		return "false";
	}

	// ɾ������ --> ����Ա���Ա
	@RequestMapping("/delPerson")
	@ResponseBody
	public String delAdmin(String[] ids, String isPerson, Model model) {
		String result = "no";
		Integer delResult = 0;
		if (isPerson.equals("����Ա")) {
			for (String id : ids) {
				// ��ɾ���˹���Ա��Ӧ�����н�ɫ��Ϣ��
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
