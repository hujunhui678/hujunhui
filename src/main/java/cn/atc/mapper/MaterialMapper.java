package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Material;
import cn.atc.pojo.ReceiveCollectMaterialDesc;

public interface MaterialMapper {
	List<Material> getAllMaterials();
	List<Material> getMaterialsByCondition(Map<String, Object>map);
	Integer getMaterialsCountByCondition(Map<String, Object>map); 
	Integer getOutMaterials(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);// �����Ͽ����ȡ���(�����������)
	Integer insertMater(@Param("id")Integer id);//��������������
	Integer getInFinishedProductsStock(ReceiveCollectMaterialDesc receiveCollectMaterialDesc);// ���Ʒ����м������(�����������)
	
		int update(Material material);
}
