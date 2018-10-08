package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.PartType;

/**
 * 零件型号mapper
 * @author ASUS
 *
 */
public interface PartTypeMapper {
	
	List<PartType> getPartTypes(); // 获取所有零件型号信息
	
	Integer insertPartType(PartType partType); // 添加零件型号
}
