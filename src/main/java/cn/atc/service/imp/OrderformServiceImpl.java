package cn.atc.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.OrderformMapper;
import cn.atc.pojo.Orderform;
import cn.atc.service.OrderformService;
import cn.atc.util.PageUtil;

@Service
public class OrderformServiceImpl implements OrderformService {
	@Autowired
		private OrderformMapper mapper;
	@Override
	public PageUtil<Orderform> queryAll(int currentPage, int pageSize) {
		PageUtil<Orderform> pageUtil=new PageUtil<Orderform>();
		int totalCount=mapper.Count();
		Map<String, Object>map=new HashMap<String, Object>();
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize((Integer)pageSize);
		pageUtil.setCurrentPage((Integer)currentPage);
		int startRow=pageUtil.getStartRow();
		map.put("pageSize",pageSize);
		map.put("startRow", startRow);
		List<Orderform>list=mapper.queryAll(map);
		pageUtil.setLists(list);
		return pageUtil;
	}

}
