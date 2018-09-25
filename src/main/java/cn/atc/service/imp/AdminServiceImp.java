package cn.atc.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.AdminMapper;
import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.service.AdminService;
import cn.atc.util.AddressUtils;
import cn.atc.util.DateConverter;
import cn.atc.util.OutIp;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin doLogin(String loginName) {
		return adminMapper.doLogin(loginName);
	}

	@Override
	public Map<Object, Object> maps(String id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("AllRoles", adminMapper.rolesList(id));
		map.put("OneAllPermiss", adminMapper.getPermOne(id));
		map.put("TwoAllPermiss", adminMapper.getPermTwo(id));
		map.put("ThreeAllPermiss", adminMapper.getPermThree(id));
		return map;
	}

	@Override
	public Admin getAdmin(Integer id) {
		return adminMapper.getAdmin(id);
	}

	@Override
	public Integer updateAdmin(Admin admin) {
		return adminMapper.updateAdmin(admin);
	}

	@Override
	public Integer getAdminByLoginNameModifyCount(Integer id) {
		return adminMapper.getAdminByLoginNameModifyCount(id);
	}

	@Override
	public Integer updatePwd(Admin admin) {
		return adminMapper.updatePwd(admin);
	}

	@Override
	public Integer addLoginLog(LoginLog log) {
		log.setLoginIP(OutIp.INTRANET_IP);// 获得本机外网IP
		log.setLoginAddress("江苏徐州");
		log.setLoginTime(DateConverter.getSqlDate());
		return adminMapper.addLoginLog(log);
	}

	@Override
	public Admin getAdminByLoginName(String loginName) {
		return adminMapper.getAdminByLoginName(loginName);
	}

}
