package cn.atc.service;

import java.util.List;

import cn.atc.pojo.PartType;

/**
 * ����ͺ�Service
 * @author ASUS
 *
 */
public interface PartTypeService {

	List<PartType> getPartTypes();
	
	Integer insertPartType(PartType partType);
}
