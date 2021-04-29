package com.StarBucks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.OrderItem;

public interface OrderConfirmDao {
	void insert(@Param("oc")OrderItem o);
	List<OrderItem> FindAllByOrderId(@Param("OId")String Id);
	void delOrderItem(@Param("OrderConfirmId")String Id);
}
