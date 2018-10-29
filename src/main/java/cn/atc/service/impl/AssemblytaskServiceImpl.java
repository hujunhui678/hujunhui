package cn.atc.service.impl;

import cn.atc.mapper.AssemblytaskMapper;
import cn.atc.pojo.Assemblytask;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class AssemblytaskServiceImpl implements AssemblytaskService {
    @Resource(name="assemblytaskMapper")
    AssemblytaskMapper mapper;
    @Override
    public List<Assemblytask> getAssemblytaskList() {
        return mapper.selectAllWithEntity();
    }

    @Override
    public void saveAssemblytask(Assemblytask assemblytask) {
        mapper.insertSelective(assemblytask);
    }

    @Override
    public void deleteAssemblytask(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Assemblytask selectById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Assemblytask selectByIdWithEntitys(String id) {
        return mapper.selectByIdWithEntitys(id);
    }

    @Override
    public void updateBySelective(Assemblytask assemblytask) {
        mapper.updateByPrimaryKeySelective(assemblytask);
    }

    @Override
    public List<FinishedProductsType> getFinishedTypesList() {
        return mapper.selectAllFinishedproductstype();
    }

    @Override
    public List<PartFormula> getParformulaList() {
        return mapper.selectAllParformulas();
    }

	@Override
	public List<Assemblytask> selectAllWithEntityById(String fin) {
		return mapper.selectAllWithEntityById(fin);
	}
}
