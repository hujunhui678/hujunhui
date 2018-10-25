package cn.atc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.pojo.ReceiveCollectMaterialDesc;

public interface ReceiveCollectMaterialDescService {
	// �������쵥�Ż�ȡ���쵥��ϸ
	List<ReceiveCollectMaterial> getMaterialDescByMaterialId(@Param("materialId")Long materialId);
	
	//�������ϵ���ϸ��(����)
	Integer insertReceiveDesc(@Param("rcmd")List<ReceiveCollectMaterialDesc> rcmd);
}
