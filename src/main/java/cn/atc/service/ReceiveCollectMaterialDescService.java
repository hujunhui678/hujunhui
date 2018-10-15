package cn.atc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;

public interface ReceiveCollectMaterialDescService {
	// 根据收领单号获取收领单详细
	List<ReceiveCollectMaterial> getMaterialDescByMaterialId(@Param("materialId")Long materialId);
}
