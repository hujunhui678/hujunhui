package cn.atc.mapper;

import cn.atc.pojo.Productivetask;
import cn.atc.pojo.ProductivetaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductivetaskMapper {
    long countByExample(ProductivetaskExample example);

    int deleteByExample(ProductivetaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(Productivetask record);

    int insertSelective(Productivetask record);

    List<Productivetask> selectByExample(ProductivetaskExample example);

    List<Productivetask> selectAllWithEntity();

    Productivetask selectByPrimaryKey(String id);

    Productivetask selectByIdWithEntitys(String id);

    int updateByExampleSelective(@Param("record") Productivetask record, @Param("example") ProductivetaskExample example);

    int updateByExample(@Param("record") Productivetask record, @Param("example") ProductivetaskExample example);

    int updateByPrimaryKeySelective(Productivetask record);

    int updateByPrimaryKey(Productivetask record);

}