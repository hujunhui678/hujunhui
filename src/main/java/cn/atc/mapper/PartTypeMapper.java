package cn.atc.mapper;

import java.util.List;

import cn.atc.pojo.PartType;

/**
 * ����ͺ�mapper
 * @author ASUS
 *
 */
public interface PartTypeMapper {
	
	List<PartType> getPartTypes(); // ��ȡ��������ͺ���Ϣ
	public List<PartType> queryAll();
	Integer insertPartType(PartType partType); // �������ͺ�
	List<PartType> getAllType();//��ȡ�����������
}
