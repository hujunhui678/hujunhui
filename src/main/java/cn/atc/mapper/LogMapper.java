package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.LoginLog;

public interface LogMapper {
	List<LoginLog> getAllLog(Map<String, Object> maps);//�鿴��¼����־
	Integer count(Map<String, Object> maps);//��ȡ����
	
	Integer delLog(@Param("day")Integer day);//ɾ������ǰ�ĵ�¼��־
}
