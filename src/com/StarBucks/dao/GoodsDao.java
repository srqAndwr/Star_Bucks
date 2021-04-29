package com.StarBucks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.Goods;

public interface GoodsDao {
	List<Goods> FindAll();
	List<Goods> FindAllNos();
	List<Goods> ByType(@Param("type")Integer type);
	Goods ByGoodId(@Param("Id")Integer goodId);
	Goods ByGoodName(@Param("Name")String name);
	void updateStatus(@Param("Id")Integer goodId,@Param("status")Integer status);
	void update(@Param("Id")Integer goodId,@Param("price")Double price,@Param("details")String details,@Param("name")String goodsname);
	void insert(@Param("g")Goods g);
}
