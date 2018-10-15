package cn.atc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Client;
import cn.atc.pojo.Orderform;
import cn.atc.util.PageUtil;

public interface ClientService {
	
	PageUtil<Client> queryAll(int currentPage, int pageSize,String clientCompany);
	
	List<Client> getClient();
	int add(Client client);
	
	int delete(@Param("ids")int[] id);
	
	int update(Client client);
	Client queryId(int id);
}
