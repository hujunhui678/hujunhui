package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Quality;
import cn.atc.util.PageUtil;

public interface QualityService {
	//质量检测分页显示
	PageUtil<Quality> queryAll(int deptNo,String partType,int startRow,int pageSize);
	
	//添加
	public int addQuality(Quality quality);
	
	//删除
	public int deleteQuality(@Param("id")int id);
	
	//修改编辑
	public int updateQuality(Quality quality);
	
	//根据ID修改
	public Quality getQualityId(@Param("id")int id);
}
