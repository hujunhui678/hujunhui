package cn.atc.service.imp;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.AdminMapper;
import cn.atc.pojo.Admin;
import cn.atc.service.AdminService;

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

}
