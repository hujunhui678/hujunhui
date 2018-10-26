package cn.atc.mapper;

import cn.atc.pojo.Assembly;
import cn.atc.pojo.AssemblyExample;
import cn.atc.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssemblyMapper {
    long countByExample(AssemblyExample example);

    int deleteByExample(AssemblyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Assembly record);

    int insertSelective(Assembly record);

    List<Assembly> selectByExample(AssemblyExample example);

    Assembly selectByPrimaryKey(Long id);

    List<Assembly> selectAllWithAssemblyPeople();

    int updateByExampleSelective(@Param("record") Assembly record, @Param("example") AssemblyExample example);

    int updateByExample(@Param("record") Assembly record, @Param("example") AssemblyExample example);

    int updateByPrimaryKeySelective(Assembly record);

    int updateByPrimaryKey(Assembly record);

    Assembly selectAllWithAssemblyPeopleById(long id);

    List<Employee> selectAllAssemblyPeople();
}