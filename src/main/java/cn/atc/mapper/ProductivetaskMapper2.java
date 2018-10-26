package cn.atc.mapper;


import cn.atc.pojo.Productivetask2;
import cn.atc.pojo.ProductivetaskExample2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductivetaskMapper2 {
    long countByExample(ProductivetaskExample2 example);

    int deleteByExample(ProductivetaskExample2 example);

    int deleteByPrimaryKey(String id);

    int insert(Productivetask2 record);

    int insertSelective(Productivetask2 record);

    List<Productivetask2> selectByExample(ProductivetaskExample2 example);

    Productivetask2 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Productivetask2 record, @Param("example") ProductivetaskExample2 example);

    int updateByExample(@Param("record") Productivetask2 record, @Param("example") ProductivetaskExample2 example);

    int updateByPrimaryKeySelective(Productivetask2 record);

    int updateByPrimaryKey(Productivetask2 record);

    List<Productivetask2> getAllProduct(Map<String, Object> map);
    int getProductivetasktCount();

    int addProductivetask(Productivetask2 productivetask);

    int updateProductivetask(Productivetask2 productivetask);

    /**
     * 鏍规嵁涓婚敭鍒犻櫎鐢熶骇浠诲姟涔�
     * @param id
     * @return
     */
    int deleteProductivetask(String id);
}