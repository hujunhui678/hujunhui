package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.LoginLog;
import cn.atc.util.PageUtil;

public interface LogService {
	PageUtil<LoginLog> getAllLog(Map<String,Object> maps);//查看登录的日志
	Integer delLog(@Param("day")Integer day);//删除几天前的登录日志
	
}
