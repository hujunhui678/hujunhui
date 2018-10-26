package cn.atc.service;

import java.util.List;
import java.util.Map;

import cn.atc.pojo.*;
import cn.atc.util.PageUtil;

public interface ProductiveTaskService {
//	PageUtil<Productivetask2> getProductivetask(Map<String, Object> maps);
//
//	// 娣诲姞浜у搧鐢熶骇璁″垝涔�
//	boolean addProductiveTask(Productivetask2 productivetask);
//
//	//鏇存柊鐢熶骇浠诲姟涔�
//	boolean updateProductivetask(Productivetask2 productivetask);

//	//鏍规嵁涓婚敭鎵归噺鍒犻櫎鐢熶骇浠诲姟涔�
//	boolean deleteProductiveTask(String[] ids);

	List<Productivetask> getProductivetaskList();

	void saveProductiveTask(Productivetask productivetask);

	void deleteProductiveTask(String id);

    void updateBySelective(Productivetask productivetask);

	Productivetask selectByIdWithEntitys(String id);

	List<String> getAllProductiveTaskId();
}
