package cn.atc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;

public interface ReceiveCollectMaterialDescService {
	// 根据收领单号获取收领单详细
	List<ReceiveCollectMaterial> getMaterialDescByMaterialId(@Param("materialId")Long materialId);
	
	//新增领料单详细表(批量)
	Integer insertReceiveDesc(@Param("rcmd")List<ReceiveCollectMaterialDesc> rcmd);
}
