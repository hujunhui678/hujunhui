package cn.atc.service;

import cn.atc.pojo.Employee;
import cn.atc.pojo.Production;

import java.util.List;

public interface ProductionService {

    List<Production> getProductionList();

    void saveproduction(Production production);

    void deleteProduction(long id);

    void updateBySelective(Production production);

    Production selectByIdWithEntitys(long id);

    List<Employee> getProductionPeople();
}
