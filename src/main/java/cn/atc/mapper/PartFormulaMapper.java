package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.PartFormula;

public interface PartFormulaMapper {
	List<PartFormula> getAllPartFrom(Map<String, Object> maps);//��ѯ���е��䷽
	Integer count(Map<String, Object> maps);
}
