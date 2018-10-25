package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.Quality;

public interface QualityMapper {
	//չʾ������Ϣ����������飩
	public List<Quality> queryAll(Map<String, Object> map);
	//��ȡҳ��
	public Integer getQualityTocount(Map<String , Object> map);
	
	//���
	public int addQuality(Quality quality);
	
	//ɾ��
	public int deleteQuality(@Param("id")int id);
	
	//�޸ı༭
	public int updateQuality(Quality quality);
	//����ID�޸�
	public Quality getQualityId(@Param("id")int id);
}
