package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.ReceiveCollectMaterial;

/**
 * 收领料单mapper
 * @author ASUS
 *
 */
public interface ReceiveCollectMaterialMapper {
	List<ReceiveCollectMaterial> getReceiveCollectMaterialByCondition(Map<String, Object> map);// 根据条件获取收领料单
	Integer getReceiveCollectMaterialCountByCondition(Map<String, Object>map);// 根据条件获取收领料单条数
	Integer updateIsAgreeById(Map<String, Object>map);// 审批通过 修改状态
}
