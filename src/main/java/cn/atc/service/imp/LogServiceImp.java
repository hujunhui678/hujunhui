package cn.atc.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.LogMapper;
import cn.atc.pojo.Admin;
import cn.atc.pojo.LoginLog;
import cn.atc.service.LogService;
import cn.atc.util.PageUtil;

@Service
public class LogServiceImp implements LogService {

	@Autowired
	private LogMapper logMapper;

	@Override
	public PageUtil<LoginLog> getAllLog(Map<String, Object> maps) {
		PageUtil<LoginLog> page = new PageUtil<LoginLog>();
		maps.put("pageSize",10);
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(logMapper.count(maps));
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(logMapper.getAllLog(maps));
		return page;
	}


}
