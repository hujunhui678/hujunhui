package cn.atc.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Quality;
import cn.atc.util.PageUtil;

public interface QualityService {
	//��������ҳ��ʾ
	PageUtil<Quality> queryAll(int deptNo,String partType,int startRow,int pageSize);
	
	//���
	public int addQuality(Quality quality);
	
	//ɾ��
	public int deleteQuality(@Param("id")int id);
	
	//�޸ı༭
	public int updateQuality(Quality quality);
	
	//����ID�޸�
	public Quality getQualityId(@Param("id")int id);
}
