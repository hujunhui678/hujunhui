package cn.atc.service;


import cn.atc.pojo.Assembly;
import cn.atc.pojo.Employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AssemblyService {
    List<Assembly> getAssemblyList();

    void saveAssemblytask(Assembly assembly);

    void deleteAssembly(long id);

    List<Assembly> selectAllWithAssemblyPeopleByPer(@Param("per")String per);
    void updateBySelective(Assembly assembly);

    Assembly selectByIdWithEntitys(long id);

    List<Employee> getAssemblypeople();
}
