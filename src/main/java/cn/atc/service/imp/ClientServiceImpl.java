package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.ClientMapper;
import cn.atc.pojo.Client;
import cn.atc.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
		
	@Autowired
		private ClientMapper mapper;
	@Override
	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return mapper.getClient();
	}

}
