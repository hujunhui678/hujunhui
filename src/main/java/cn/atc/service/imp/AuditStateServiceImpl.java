package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.AuditStateMapper;
import cn.atc.pojo.AuditState;
import cn.atc.service.AuditStateService;

/**
 * ÉóºË×´Ì¬Service
 * @author ASUS
 *
 */
@Service
public class AuditStateServiceImpl implements AuditStateService {

	@Autowired
	private AuditStateMapper auditStateMapper;
	
	@Override
	public List<AuditState> getAuditStates() {
		return auditStateMapper.getAuditStates();
	}

}
