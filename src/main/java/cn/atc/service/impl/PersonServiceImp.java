package cn.atc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PersonMapper;
import cn.atc.pojo.Admin;
import cn.atc.pojo.Admin_Role;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Role;
import cn.atc.service.PersonService;
import cn.atc.util.PageUtil;

@Service
public class PersonServiceImp implements PersonService {
	@Autowired
	private PersonMapper personMapper;

	@Override
	public PageUtil<Admin> getAllAdmin(Map<String, Object> maps) {
		PageUtil<Admin> page = new PageUtil<Admin>();
		maps.put("pageSize", 2);
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(personMapper.getAdminToCount());
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(personMapper.getAllAdmin(maps));
		return page;
	}

	@Override
	public PageUtil<Admin> getAllEmp(Map<String, Object> maps) {
		PageUtil<Admin> page = new PageUtil<Admin>();
		maps.put("pageSize", 2);
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(personMapper.getEmpToCount());
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(personMapper.getAllEmp(maps));
		return page;
	}

	@Override
	public Integer getAdminPhone(String phone) {
		return personMapper.getAdminPhone(phone);
	}

	@Override
	public Integer addAdmin(Admin admin) {
		return personMapper.addAdmin(admin);
	}

	@Override
	public Integer getAdminIdByPhone(String phone) {
		return personMapper.getAdminIdByPhone(phone);
	}

	@Override
	public List<Admin> getAdminNameAndChildDept(Integer id) {
		return personMapper.getAdminNameAndChildDept(id);
	}

	@Override
	public List<Admin_Role> getAdminAllRole(Integer id) {
		return personMapper.getAdminAllRole(id);
	}

	@Override
	public Integer updateAdmin(Admin admin) {
		return personMapper.updateAdmin(admin);
	}

	@Override
	public Integer delAdminRole(Integer adminId) {
		return personMapper.delAdminRole(adminId);
	}

	@Override
	public Integer delAdmin(String[] ids) {
		return personMapper.delAdmin(ids);
	}

	@Override
	public Integer delEmp(String[] ids) {
		return personMapper.delEmp(ids);
	}

	@Override
	public Integer addEmp(Employee employee) {
		return personMapper.addEmp(employee);
	}

	@Override
	public Integer updateEmp(Employee emp) {
		return personMapper.updateEmp(emp);
	}

	@Override
	public List<Employee> getEmpAndChildDept(Integer id) {
		return personMapper.getEmpAndChildDept(id);
	}

}
