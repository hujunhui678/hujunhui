package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Client;
import cn.atc.pojo.Orderform;
import cn.atc.util.PageUtil;

public interface OrderformService {
	PageUtil<Orderform> queryAll(int currentPage, int pageSize,String state,String id);
	
	Integer delete(@Param("ids")Long[] id);
	
	List<Orderform>getquery();
	
	Integer add(Orderform orderform);
	Integer update(Orderform orderform);
	Orderform queryId(String id);
}
