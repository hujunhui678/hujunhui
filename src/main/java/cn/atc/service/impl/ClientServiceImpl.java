package cn.atc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ClientMapper;
import cn.atc.pojo.Client;
import cn.atc.pojo.Orderform;
import cn.atc.service.ClientService;
import cn.atc.util.PageUtil;

@Service
public class ClientServiceImpl implements ClientService {
		
	@Autowired
		private ClientMapper mapper;
	@Override
	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return mapper.getClient();
	}
	@Override
	public int add(Client client) {
		// TODO Auto-generated method stub
		return mapper.add(client);
	}
	@Override
	public int delete(int[] id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	@Override
	public int update(Client client) {
		// TODO Auto-generated method stub
		return mapper.update(client);
	}
	@Override
	public Client queryId(int id) {
		// TODO Auto-generated method stub
		return mapper.queryId(id);
	}
	@Override
	public PageUtil<Client> queryAll(int currentPage, int pageSize,String clientCompany) {
		PageUtil<Client> pageUtil=new PageUtil<Client>();
		int totalCount=mapper.Count();
		Map<String, Object>map=new HashMap<String, Object>();
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize((Integer)pageSize);
		pageUtil.setCurrentPage((Integer)currentPage);
		int startRow=pageUtil.getStartRow();
		map.put("pageSize",pageSize);
		map.put("startRow", startRow);
		map.put("clientCompany", clientCompany);
		List<Client>list=mapper.queryAll(map);
		pageUtil.setLists(list);
		return pageUtil;
	}


}
