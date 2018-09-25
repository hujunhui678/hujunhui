package cn.atc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.service.AdminService;

@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object doLogin(String loginName, String pwd, Boolean isRemember, String code, Model model,
			HttpSession session, HttpServletRequest request) {
		// ��֤��֤��
		String sessionCode = request.getSession().getAttribute("code").toString();
		String message = "";
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, pwd);
		token.setRememberMe(isRemember);
		try {
			subject.login(token);
			System.out.println(code);
			if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
				if (code.equalsIgnoreCase(sessionCode)) {// ���Դ�Сд
					// ��¼�ɹ�
					System.out.println("��¼�ɹ�");
					// �����¼��־��..
					Admin admin = adminService.getAdminByLoginName(loginName);
					LoginLog log = new LoginLog();
					log.setLoginName(loginName);
					log.setName(admin.getName());
					adminService.addLoginLog(log);
					message = null;
				} else {
					message = "��֤���벻��ȷ��";
				}
			} else {
				message = "��֤���벻��ȷ��";
			}
		} catch (UnknownAccountException e) {
			// �û�������
			message = "�û���������";
			e.printStackTrace();
		} catch (IncorrectCredentialsException e) {
			// �������
			message = "�û������������";
			e.printStackTrace();
		} catch (Exception e) {
			message = "��¼�쳣";
			e.printStackTrace();
		} finally {
			return message;
		}
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "redirect:login.jsp";
	}

}
