package cn.atc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.PartClassify;

/**
 * �������Mapper
 * @author ASUS
 *
 */
public interface PartClassifyMapper {
	// ��ȡ����������
	List<PartClassify> getAllPartClassifies();
}
