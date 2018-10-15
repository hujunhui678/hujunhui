package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Client;

public interface ClientMapper {
	List<Client> getClient();
List<Client>queryAll(Map<String, Object> map);
	Integer Count();
	
	int add(Client client);
	int delete(@Param("adminIds")int[] id);
	
	Client queryId(int id);
	int update(Client client);
}
