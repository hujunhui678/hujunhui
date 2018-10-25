package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Quality;

public interface QualityMapper {
	//展示所有信息（质量检测书）
	public List<Quality> queryAll(Map<String, Object> map);
	//获取页数
	public Integer getQualityTocount(Map<String , Object> map);
	
	//添加
	public int addQuality(Quality quality);
	
	//删除
	public int deleteQuality(@Param("id")int id);
	
	//修改编辑
	public int updateQuality(Quality quality);
	//根据ID修改
	public Quality getQualityId(@Param("id")int id);
}
