package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Material;

public interface MaterialMapper {
	List<Material> getMaterialsByCondition(Map<String, Object>map);
	int getMaterialsCountByCondition(Map<String, Object>map);
}
