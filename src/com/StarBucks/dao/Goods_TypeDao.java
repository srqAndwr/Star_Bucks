package com.StarBucks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.Goods_Type;

public interface Goods_TypeDao {
	List<Goods_Type> FindAll();
	Goods_Type TypeNameById(@Param("GId")Integer Id);
}
