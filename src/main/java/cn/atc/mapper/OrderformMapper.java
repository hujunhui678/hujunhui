package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Orderform;

public interface OrderformMapper {
	//��ҳ��ѯ
	List<Orderform> queryAll(Map<String, Object> map);
	//��ȡ����
	Integer Count();
}
