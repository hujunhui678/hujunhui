package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.LoginLog;

public interface LogMapper {
	List<LoginLog> getAllLog(Map<String, Object> maps);//�鿴��¼����־
	Integer count(Map<String, Object> maps);//��ȡ����
}
