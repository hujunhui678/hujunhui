package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.PartFormulaDesc;
import cn.atc.pojo.PartType;

public interface PartFormulaMapper {
	List<PartFormula> getAllPartFrom(Map<String, Object> maps);//查询所有的配方
	Integer count(Map<String, Object> maps);
	
	
	List<FinishedProductsType> getAllFinish();//获得所有成品
	
	//通过parttype表的id获取 对应的分类Id
	//如果用户选择的分类id与查出来的分类id不一致则新增零件类型
	PartType getPartType(@Param("id")Integer id);
	//新增零件类型(插入成功返回主键)
	Integer addPartType(PartType partType);
	
	//新增零件配方表信息
	Integer addPartFormula(PartFormula partFormula);
	//新增零件配方详情表信息
	Integer addPartFormulaDesc(PartFormulaDesc partFormulaDesc);
	
}
