package cn.atc.controller;

import static org.hamcrest.CoreMatchers.nullValue;

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
import cn.atc.pojo.Role_perm;
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
	 * 进入权限管理页面的准备工作
	 * @param noRole 所有除人事的角色
	 * @param permLevel 权限等级
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
	 * 根据角色id获取权限
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
	
	/**
	 * 添加权限及角色权限
	 * @param permission
	 * @param role_perm
	 * @param map
	 * @return
	 */
	@RequestMapping("/addPerm")
	@ResponseBody	
	public String addPermission(Permission permission) {
		permission.setPermLevel(permission.getPermLevel()+1);
		Boolean result = false;
		try {
			result = permissionService.insertPerm(permission);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return result.toString();
	}
	
	@RequestMapping("/insertRolePerm")
	@ResponseBody
	public String insertRolePerm(String[] permIds,Integer roleId,Map<String, Object> map) {
		map.put("roleId", roleId);
		map.put("permIds", permIds);
		return permissionService.insertRolePermByRoleIdAndPermId(map)?"true":"false";
	}
}
