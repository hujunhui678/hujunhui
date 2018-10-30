package cn.atc.mapper;


import cn.atc.pojo.Assemblytask;
import cn.atc.pojo.AssemblytaskExample;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("assemblytaskMapper")
public interface AssemblytaskMapper {
    long countByExample(AssemblytaskExample example);

    int deleteByExample(AssemblytaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(Assemblytask record);

    int insertSelective(Assemblytask record);

    List<Assemblytask> selectByExample(AssemblytaskExample example);

    /**
     * 鏌ユ壘鎵�鏈夌殑瑁呴厤浠诲姟锛屽寘鎷垚鍝佺被鍨嬨�佽閰嶇彮闀裤�侀浂浠堕厤鏂�
     * @return
     */
    List<Assemblytask> selectAllWithEntity();
    List<Assemblytask> selectAllWithEntityByids(@Param("taskIds")String[] ids);
    List<Assemblytask> selectAllWithEntityById(@Param("fin")String fin);


    Assemblytask selectByPrimaryKey(String id);


    int updateByExampleSelective(@Param("record") Assemblytask record, @Param("example") AssemblytaskExample example);

    int updateByExample(@Param("record") Assemblytask record, @Param("example") AssemblytaskExample example);

    int updateByPrimaryKeySelective(Assemblytask record);

    int updateByPrimaryKey(Assemblytask record);

    List<FinishedProductsType> selectAllFinishedproductstype();

    List<PartFormula> selectAllParformulas();

    Assemblytask selectByIdWithEntitys(String id);
}