package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.FinishedproductstypeMapper;
import cn.atc.pojo.Finishedproductstype;
import cn.atc.service.FinishedproductstypeService;

@Service
public class FinishedproductstypeServiceImpl implements FinishedproductstypeService {
			@Autowired
			private FinishedproductstypeMapper mapper;
	@Override
	public List<Finishedproductstype> getFinishedproductstype() {
			
		return mapper.getFinishedproductstype();
	}

}
