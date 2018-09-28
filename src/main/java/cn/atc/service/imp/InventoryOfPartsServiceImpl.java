package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.mapper.InventoryOfPartsMapper;
import cn.atc.pojo.InventoryOfParts;
import cn.atc.service.InventoryOfPartsService;

/**
 * Áã¼þ¿â´æService
 * @author ASUS
 *
 */
@Service
public class InventoryOfPartsServiceImpl implements InventoryOfPartsService {

	@Autowired
	private InventoryOfPartsMapper inventoryOfPartsMapper;

	@Override
	public List<InventoryOfParts> getInventoryOfParts() {
		return inventoryOfPartsMapper.getInventoryOfParts();
	}

}
