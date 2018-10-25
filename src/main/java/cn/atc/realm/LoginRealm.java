package cn.atc.realm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.atc.pojo.Admin;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role;
import cn.atc.service.AdminService;
import cn.atc.util.MD5Util;

//import cn.bdqn.pojo.User;
//import cn.bdqn.service.IUserService;
//import cn.bdqn.util.MD5Util;

public class LoginRealm extends AuthorizingRealm {
	@Autowired
	private AdminService adminService;

	private String id;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("-----------------�����¼��֤-------------------");
		String name = (String) token.getPrincipal();
		Admin admin = null;
		try {
			admin = adminService.doLogin(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (admin == null) {
			throw new UnknownAccountException("�û����������");
		} else {
			MD5Util md5 = new MD5Util();
			String pwd = new String((char[]) token.getCredentials());
			if (md5.verify(pwd, admin.getPassword())) {
				AuthenticationInfo auth = new SimpleAuthenticationInfo(name, pwd, "Login");
				id = String.valueOf(admin.getId());
				SecurityUtils.getSubject().getSession().setAttribute("admin", admin);
				// ��֤��ɺ���session�в��뵱ǰ�û����н�ɫ��Ȩ��
				Map<Object, Object> map = adminService.maps(id);
				Set<Role> roles = (Set<Role>) map.get("AllRoles");// ��ȡ���û������н�ɫ��Ϣ
				Set<Permission> perm = (Set<Permission>) map.get("OneAllPermiss");// ��ȡһ��Ȩ��
				Set<Permission> perm2 = (Set<Permission>) map.get("TwoAllPermiss");// ��ȡ����Ȩ��
				SecurityUtils.getSubject().getSession().setAttribute("roleList", roles);
				SecurityUtils.getSubject().getSession().setAttribute("permOne", perm);
				SecurityUtils.getSubject().getSession().setAttribute("permTwo", perm2);
				return auth;
			} else {
				throw new IncorrectCredentialsException("�������");
			}
			//

		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("------------�����ɫ��Ȩ����֤---------------");
		String name = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		try {
			Map<Object, Object> map = adminService.maps(id);
			Set<Role> roles = (Set<Role>) map.get("AllRoles");
			Set<String> set = new HashSet<>();
			for (Role role : roles) {
				set.add(role.getRoleName());
			}
			auth.setRoles(set);
			// ����Ȩ�ޱ�ǩ
			Set<Permission> perm = (Set<Permission>) map.get("ThreeAllPermiss");
			Set<String> set1 = new HashSet<>();
			for (Permission p : perm) {
				set1.add(p.getPermNameE());
			}
			auth.setStringPermissions(set1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return auth;
	}

}
