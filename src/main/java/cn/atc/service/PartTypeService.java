package cn.atc.service;

import java.util.List;

import cn.atc.pojo.PartType;

/**
 * 零件型号Service
 * @author ASUS
 *
 */
public interface PartTypeService {

	List<PartType> getPartTypes();
	
	Integer insertPartType(PartType partType);

	List<PartType> getAllType();//获取所有零件类型
	public List<PartType> queryAll();
}
