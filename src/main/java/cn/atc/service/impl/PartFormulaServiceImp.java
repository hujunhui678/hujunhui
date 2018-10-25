package cn.atc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.atc.mapper.PartFormulaMapper;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.PartFormulaDesc;
import cn.atc.pojo.PartType;
import cn.atc.service.PartFormulaService;
import cn.atc.util.GsonUtil;
import cn.atc.util.JedisClient;
import cn.atc.util.PageUtil;

@Service
public class PartFormulaServiceImp implements PartFormulaService {

	@Autowired
	private PartFormulaMapper partFormulaMapper;

	@Autowired
	private JedisClient jedisClient;

	@Value("${REDIS_FINISH_KEY}")
	private String REDIS_FINISH_KEY;

	@Override
	public PageUtil<PartFormula> getAllPartFrom(Map<String, Object> maps) {
		PageUtil<PartFormula> page = new PageUtil<PartFormula>();
		page.setPageSize(Integer.parseInt(maps.get("pageSize").toString()));
		page.setTotalCount(partFormulaMapper.count(maps));
		page.setCurrentPage(Integer.parseInt(maps.get("pageIndex").toString()));
		int startRow = page.getStartRow();
		maps.put("startRow", startRow);
		page.setLists(partFormulaMapper.getAllPartFrom(maps));
		return page;
	}

	@Override
	public List<FinishedProductsType> getAllFinish() {
		/*// 缓存中取数据
		try {
			String result = jedisClient.get(REDIS_FINISH_KEY + "");
			if (!StringUtils.isEmpty(result)) {
				// 把字符串转成list
				List<FinishedProductsType> list = GsonUtil.GsonToList(result, FinishedProductsType.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<FinishedProductsType> list = partFormulaMapper.getAllFinish();
		// 添加缓存
		try {
			// list转换成字符串
			String cacheString = GsonUtil.GsonString(list);
			jedisClient.set(REDIS_FINISH_KEY + "", cacheString);

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return partFormulaMapper.getAllFinish();
	}

	@Override
	public Integer addPartType(PartType partType) {
		return partFormulaMapper.addPartType(partType);
	}

	@Override
	public PartType getPartType(Integer id) {
		return partFormulaMapper.getPartType(id);
	}

	@Override
	public Integer addPartFormula(PartFormula partFormula) {
		return partFormulaMapper.addPartFormula(partFormula);
	}

	@Override
	public Integer addPartFormulaDesc(PartFormulaDesc partFormulaDesc) {
		return partFormulaMapper.addPartFormulaDesc(partFormulaDesc);
	}

	@Override
	public Integer editState(HashMap<String, Object> maps) {
		return partFormulaMapper.editState(maps);
	}

	@Override
	public PartFormula getPFByid(String id) {
		return partFormulaMapper.getPFByid(id);
	}

}
