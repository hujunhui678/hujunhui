package cn.atc.service;


import cn.atc.pojo.Assembly;
import cn.atc.pojo.Employee;

import java.util.List;

public interface AssemblyService {
    List<Assembly> getAssemblyList();

    void saveAssemblytask(Assembly assembly);

    void deleteAssembly(long id);

    void updateBySelective(Assembly assembly);

    Assembly selectByIdWithEntitys(long id);

    List<Employee> getAssemblypeople();
}
