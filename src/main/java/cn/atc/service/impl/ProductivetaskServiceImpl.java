package cn.atc.service.impl;

import cn.atc.mapper.AssemblytaskMapper;
import cn.atc.mapper.*;
import cn.atc.pojo.*;
import cn.atc.service.*;
import cn.atc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductivetaskServiceImpl implements ProductiveTaskService {
    @Autowired
    private ProductivetaskMapper mapper;

    @Override
    public List<Productivetask> getProductivetaskList() {
        return mapper.selectAllWithEntity();
    }

    @Override
    public void saveProductiveTask(Productivetask productivetask) {
        mapper.insertSelective(productivetask);
    }

    @Override
    public void deleteProductiveTask(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBySelective(Productivetask productivetask) {
        mapper.updateByPrimaryKeySelective(productivetask);
    }

    @Override
    public Productivetask selectByIdWithEntitys(String id) {
        return mapper.selectByIdWithEntitys(id);
    }


    @Override
    public List<String> getAllProductiveTaskId() {
        List<Productivetask> productivetasks = mapper.selectAllWithEntity();
        List<String> ids=new ArrayList<>();
        for(Productivetask productivetask:productivetasks){
            ids.add(productivetask.getId());
        }
        return ids;
    }
}
