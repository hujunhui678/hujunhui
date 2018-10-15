package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Orderform;

public interface OrderformMapper {
	//��ҳ��ѯ
	List<Orderform> queryAll(Map<String, Object> map);
	//��ȡ����
	Integer Count();
	//���
	Integer add(Orderform orderform);
	
	List<Orderform>getquery();
	
	Integer update(Orderform orderform);
	Orderform queryId(String id);
	
	Integer delete(@Param("adminIds")Long[] id);
}
