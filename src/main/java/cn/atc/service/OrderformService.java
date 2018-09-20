package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.Orderform;
import cn.atc.util.PageUtil;

public interface OrderformService {
	PageUtil<Orderform> queryAll(int currentPage, int pageSize);
}
