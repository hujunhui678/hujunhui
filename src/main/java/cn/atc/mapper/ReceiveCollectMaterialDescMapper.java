package cn.atc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * ���쵥����Mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialDescMapper {
	// �������쵥�Ż�ȡ���쵥��ϸ
	List<ReceiveCollectMaterial> getMaterialDescByMaterialId(@Param("materialId")Long materialId);
}
