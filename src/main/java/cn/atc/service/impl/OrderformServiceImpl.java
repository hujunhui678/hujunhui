package cn.atc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.OrderformMapper;
import cn.atc.pojo.Client;
import cn.atc.pojo.Orderform;
import cn.atc.service.OrderformService;
import cn.atc.util.PageUtil;

@Service
public class OrderformServiceImpl implements OrderformService {
	@Autowired
		private OrderformMapper mapper;
	@Override
	public PageUtil<Orderform> queryAll(int currentPage, int pageSize,String state,String id) {
		PageUtil<Orderform> pageUtil=new PageUtil<Orderform>();
		int totalCount=mapper.Count();
		Map<String, Object>map=new HashMap<String, Object>();
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize((Integer)pageSize);
		pageUtil.setCurrentPage((Integer)currentPage);
		int startRow=pageUtil.getStartRow();
		map.put("state", state);
		map.put("pageSize",pageSize);
		map.put("startRow", startRow);
		map.put("id", id);
		
		List<Orderform>list=mapper.queryAll(map);
		pageUtil.setLists(list);
		return pageUtil;
	}
	@Override
	public Integer delete(Long[] id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	@Override
	public Integer add(Orderform orderform) {
		// TODO Auto-generated method stub
		return mapper.add(orderform);
	}
	@Override
	public Integer update(Orderform orderform) {
		// TODO Auto-generated method stub
		return mapper.update(orderform);
	}
	@Override
	public Orderform queryId(String id) {
		// TODO Auto-generated method stub
		return mapper.queryId(id);
	}
	@Override
	public List<Orderform> getquery() {
		// TODO Auto-generated method stub
		return mapper.getquery();
	}
	

}
