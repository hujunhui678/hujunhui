package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.LoginLog;

public interface LogMapper {
	List<LoginLog> getAllLog(Map<String, Object> maps);//查看登录的日志
	Integer count(Map<String, Object> maps);//获取数量
	
	Integer delLog(@Param("day")Integer day);//删除几天前的登录日志
}
