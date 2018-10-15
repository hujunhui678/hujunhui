package cn.atc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.PartClassifyMapper;
import cn.atc.pojo.PartClassify;
import cn.atc.service.PartClassifyService;


/**
 * 零件类别类service
 * 
 * @author ASUS
 *
 */
@Service
public class PartClassifyServiceImpl implements PartClassifyService {

	@Autowired
	private PartClassifyMapper partClassifyMapper;
	
	@Override
	public List<PartClassify> getAllPartClassifies() {
		return partClassifyMapper.getAllPartClassifies();
	}

}
