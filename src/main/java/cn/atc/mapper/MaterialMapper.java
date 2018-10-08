package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.Material;
import cn.atc.pojo.ReceiveCollectMaterialDesc;

public interface MaterialMapper {
	List<Material> getAllMaterials();
	List<Material> getMaterialsByCondition(Map<String, Object>map);
	Integer getMaterialsCountByCondition(Map<String, Object>map); 
	Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);// 从物料库存中取零件(减少零件数量)
}
