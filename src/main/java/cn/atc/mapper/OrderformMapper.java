package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Orderform;

public interface OrderformMapper {
	//分页查询
	List<Orderform> queryAll(Map<String, Object> map);
	//获取行数
	Integer Count();
}
