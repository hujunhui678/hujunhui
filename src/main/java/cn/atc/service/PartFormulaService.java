package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.PartFormula;
import cn.atc.util.PageUtil;

public interface PartFormulaService {
	PageUtil<PartFormula> getAllPartFrom(Map<String, Object> maps);// ��ѯ���е��䷽

}
