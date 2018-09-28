package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.Material;
import cn.atc.util.PageUtil;

public interface MaterialService {
	PageUtil<Material> getMaterialsByCondition(Map<String, Object>map);
}	
