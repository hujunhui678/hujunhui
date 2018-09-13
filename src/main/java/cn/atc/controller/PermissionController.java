package cn.atc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.AllPerm;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;
import cn.atc.service.PermissionService;
import cn.atc.service.RoleService;
import cn.atc.util.GsonUtil;

@Controller
@RequestMapping("/page")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * ����Ȩ�޹���ҳ���׼������
	 * @param noRole ���г����µĽ�ɫ
	 * @param permLevel Ȩ�޵ȼ�
	 * @param parentPermId 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/permission")
	public String getRoleNoRole(String noRole,Integer permLevel,String parentPermId,Map<String, Object> map,Model model) {
		map.put("noRole", noRole);
		List<Role> roleList = roleService.getRoleNoRole(map);
		List<AllPerm> permList = permissionService.getPerm();
		model.addAttribute("roleList",roleList);
		model.addAttribute("permList",permList);
		return "perm";
	}
	
	/**
	 * ���ݽ�ɫid��ȡȨ��
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPermByRole")
	@ResponseBody
	public String getPermByRole(long id) {
		List<AllPerm> permList = permissionService.getPermByRoleId(id);
		String json = GsonUtil.GsonString(permList);
		return json;
	}
	
	@RequestMapping("/getPermByLevel")
	@ResponseBody
	public String getPermByLevel(Integer permLevel) {
		List<Permission> permList = permissionService.getAllPermConverterPerm(permLevel);
		String json = GsonUtil.GsonString(permList);
		return json;
	}
}
