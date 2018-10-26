package cn.atc.service;

import cn.atc.pojo.Assemblytask;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;

import java.util.List;

public interface AssemblytaskService {
    List<Assemblytask> getAssemblytaskList();

    void saveAssemblytask(Assemblytask assemblytask);

    void deleteAssemblytask(String id);

    Assemblytask selectById(String id);

    Assemblytask selectByIdWithEntitys(String id);

    void updateBySelective(Assemblytask assemblytask);

    List<FinishedProductsType> getFinishedTypesList();

    List<PartFormula> getParformulaList();
}
