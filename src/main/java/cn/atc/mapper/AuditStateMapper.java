package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.AuditState;

/**
 * 审核状态表Mapper
 * @author ASUS
 *
 */
public interface AuditStateMapper {
	// 获取所有审核状态
	List<AuditState> getAuditStates();
}
