package cn.atc.service;

import cn.atc.pojo.Assemblytask;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AssemblytaskService {
    List<Assemblytask> getAssemblytaskList();

    void saveAssemblytask(Assemblytask assemblytask);

    void deleteAssemblytask(String id);

    Assemblytask selectById(String id);

    Assemblytask selectByIdWithEntitys(String id);
    List<Assemblytask> selectAllWithEntityById(@Param("fin")String fin);

    void updateBySelective(Assemblytask assemblytask);

    List<FinishedProductsType> getFinishedTypesList();

    List<PartFormula> getParformulaList();
}
