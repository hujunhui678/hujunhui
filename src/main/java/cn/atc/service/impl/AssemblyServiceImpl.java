package cn.atc.service.impl;

import cn.atc.mapper.AssemblyMapper;
import cn.atc.pojo.Assembly;
import cn.atc.pojo.Employee;
import cn.atc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssemblyServiceImpl implements AssemblyService {
    @Autowired
    private AssemblyMapper assemblyMapper;

    @Override
    public List<Assembly> getAssemblyList() {
        return assemblyMapper.selectAllWithAssemblyPeople();
    }

    @Override
    public void saveAssemblytask(Assembly assembly) {
        assemblyMapper.insertSelective(assembly);
    }

    @Override
    public void deleteAssembly(long id) {
        assemblyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBySelective(Assembly assembly) {
        assemblyMapper.updateByPrimaryKeySelective(assembly);
    }

    @Override
    public Assembly selectByIdWithEntitys(long id) {
        return assemblyMapper.selectAllWithAssemblyPeopleById(id);
    }

    @Override
    public List<Employee> getAssemblypeople() {
        return assemblyMapper.selectAllAssemblyPeople();
    }

	@Override
	public List<Assembly> selectAllWithAssemblyPeopleByPer(String per) {
		return assemblyMapper.selectAllWithAssemblyPeopleByPer(per);
	}

}
