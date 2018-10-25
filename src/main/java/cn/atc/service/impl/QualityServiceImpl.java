package cn.atc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.atc.mapper.QualityMapper;
import cn.atc.pojo.Quality;
import cn.atc.service.QualityService;
import cn.atc.util.PageUtil;
@Service("qualityService")
public class QualityServiceImpl implements QualityService {

	
	@Resource(name="qualityMapper")
	private QualityMapper qualityMapper;
	@Override
	public PageUtil<Quality> queryAll(int deptNo,String partType,int startRow,int pageSize) {
		
		PageUtil<Quality> pageUtil=new PageUtil<Quality>();
		Map<String , Object> map=new HashMap<String,Object>();
		
		map.put("deptNo",deptNo);
		
		
		/*pageUtil.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		pageUtil.setTotalCount(qualityMapper.getQualityTocount());
		pageUtil.setCurrentPage(Integer.parseInt(map.get("pageIndex").toString()));*/
		int totalCount=qualityMapper.getQualityTocount(map);
		
		pageUtil.setTotalCount(totalCount);
		pageUtil.setPageSize(pageSize);
		pageUtil.setCurrentPage(startRow);
		int pageIndex = pageUtil.getStartRow();
		map.put("startRow", pageIndex);
		map.put("pageSize", pageSize);
		map.put("partType", partType);
		List<Quality> lists=qualityMapper.queryAll(map);
		pageUtil.setLists(lists);
		return pageUtil;
	}
	@Override
	public int addQuality(Quality quality) {
		// TODO Auto-generated method stub
		return qualityMapper.addQuality(quality);
	}
	@Override
	public int deleteQuality(int id) {
		// TODO Auto-generated method stub
		return qualityMapper.deleteQuality(id);
	}
	@Override
	public int updateQuality(Quality quality) {
		// TODO Auto-generated method stub
		return qualityMapper.updateQuality(quality);
	}
	@Override
	public Quality getQualityId(int id) {
		// TODO Auto-generated method stub
		return qualityMapper.getQualityId(id);
	}

}
