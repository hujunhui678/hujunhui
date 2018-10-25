package cn.atc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Material;
import cn.atc.pojo.ReceiveCollectMaterialDesc;
import cn.atc.util.PageUtil;

public interface MaterialService {
	PageUtil<Material> getMaterialsByCondition(Map<String, Object>map);
	List<Material> getAllMaterials();
	Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);
	Integer insertMater(@Param("id")Integer id);//��������������
	Integer getInFinishedProductsStock(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);// ���Ʒ����м������(�����������)
}	
