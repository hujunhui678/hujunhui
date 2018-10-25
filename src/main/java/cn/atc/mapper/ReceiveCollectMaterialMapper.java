package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.ProductionPlan;
import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * 收领料单mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialMapper {
	List<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// 根据条件获取收领料单
	Integer getReceiveCollectMaterialCountByCondition(Map<String, Object>map);// 根据条件获取收领料单条数
	Integer updateIsAgreeById(Map<String, Object> map);// 审批通过 修改状态
	Integer updateIsAgreeByIdH(Map<String, Object> map);// 审批通过 修改状态
	
	Integer insertReceive(ReceiveCollectMaterial rcm);//新增领料单
	
	Integer auditReceive(ReceiveCollectMaterial rcm);//审核领料单
	
	//查询审核不通过原因
	ReceiveCollectMaterial getReason(@Param("id")String id);
	
	Integer delReveive(@Param("id")String id);
}
