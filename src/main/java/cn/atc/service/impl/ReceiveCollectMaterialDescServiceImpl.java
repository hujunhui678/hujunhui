package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ReceiveCollectMaterialDescMapper;
import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.service.ReceiveCollectMaterialDescService;

/**
 * 收领单详情Service
 * @author ASUS
 *
 */
@Service
public class ReceiveCollectMaterialDescServiceImpl implements ReceiveCollectMaterialDescService {

	@Autowired
	private ReceiveCollectMaterialDescMapper receiveCollectMaterialDescMapper;
	
	@Override
	public List<ReceiveCollectMaterial> getMaterialDescByMaterialId(Long materialId) {
		return receiveCollectMaterialDescMapper.getMaterialDescByMaterialId(materialId);
	}

}
