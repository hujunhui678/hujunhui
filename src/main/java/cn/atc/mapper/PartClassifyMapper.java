package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.PartClassify;

/**
 * 零件分类Mapper
 * @author ASUS
 *
 */
public interface PartClassifyMapper {
	// 获取所有零件类别
	List<PartClassify> getAllPartClassifies();
}
