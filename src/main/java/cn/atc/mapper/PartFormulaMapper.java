package cn.atc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.PartFormulaDesc;
import cn.atc.pojo.PartType;

public interface PartFormulaMapper {
	List<PartFormula> getAllPartFrom(Map<String, Object> maps);//��ѯ���е��䷽
	Integer count(Map<String, Object> maps);
	
	
	List<FinishedProductsType> getAllFinish();//������г�Ʒ
	
	//ͨ��parttype���id��ȡ ��Ӧ�ķ���Id
	//����û�ѡ��ķ���id�������ķ���id��һ���������������
	PartType getPartType(@Param("id")Integer id);
	//�����������(����ɹ���������)
	Integer addPartType(PartType partType);
	
	//��������䷽����Ϣ
	Integer addPartFormula(PartFormula partFormula);
	//��������䷽�������Ϣ
	Integer addPartFormulaDesc(PartFormulaDesc partFormulaDesc);
	
}
