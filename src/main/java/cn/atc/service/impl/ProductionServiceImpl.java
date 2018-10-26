package cn.atc.service.impl;


import cn.atc.mapper.*;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Production;
import cn.atc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionMapper mapper;

    @Override
    public List<Production> getProductionList() {
        return mapper.selectAllWithEntitys();
    }

    @Override
    public void saveproduction(Production production) {
        mapper.insertSelective(production);
    }

    @Override
    public void deleteProduction(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBySelective(Production production) {
        mapper.updateByPrimaryKeySelective(production);
    }

    @Override
    public Production selectByIdWithEntitys(long id) {
        return mapper.selectWithEntitysById(id);
    }

    @Override
    public List<Employee> getProductionPeople() {
        return mapper.selectAllProductionPeople();
    }
}
