package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ReceiveCollectMaterial;
import cn.atc.util.PageUtil;

public interface ReceiveCollectMaterialService {
	PageUtil<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// 根据条件获取收领料单

	Integer updateIsAgreeById(Map<String, Object> map);// 审批通过 修改状态

	Integer insertReceive(ReceiveCollectMaterial rcm);// 新增领料单

	Integer auditReceive(ReceiveCollectMaterial rcm);// 审核领料单

	//查询审核不通过原因
	ReceiveCollectMaterial getReason(@Param("id")String id);
	
	//删除领料单，先进行删除领料详情单
	Integer delReveive(@Param("id")String id);
}
