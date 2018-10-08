package cn.atc.service;

import java.util.Map;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.util.PageUtil;

public interface ReceiveCollectMaterialService {
	PageUtil<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);//根据条件获取收领料单
	Integer updateIsAgreeById(Map<String, Object>map);// 审批通过 修改状态
}
