package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ChildDeptMapper;
import cn.atc.pojo.ChildDept;
import cn.atc.service.ChildDeptService;

@Service
public class ChildDeptServiceImpl implements ChildDeptService {

	@Autowired
	private ChildDeptMapper childDeptMapper;
	
	@Override
	public List<ChildDept> getChildDept() {
		return childDeptMapper.getChildDept();
	}

}
