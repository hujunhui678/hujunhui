package cn.atc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * 收领单详情Mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialDescMapper {
	// 根据收领单号获取收领单详细
	List<ReceiveCollectMaterial> getMaterialDescByMaterialId(@Param("materialId")Long materialId);
}
