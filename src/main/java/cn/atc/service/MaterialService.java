package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Material;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.util.PageUtil;

public interface MaterialService {
	PageUtil<Material> getMaterialsByCondition(Map<String, Object>map);
	List<Material> getAllMaterials();
	Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);
}	
