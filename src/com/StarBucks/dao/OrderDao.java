package com.StarBucks.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.*;

public interface OrderDao {
	List<Order> FindToBePaid(@Param("CId")Integer id);
	List<Order> FindPaid(@Param("CId")Integer id);
	void insertPaid(@Param("o")Order o);
	void insertToBePaid(@Param("o")Order o);
	Custom FindContacts(@Param("OId")String id);
	void Pay(@Param("payTime")Date time,@Param("OrderId")String id);
	void delOrder(@Param("OrderId")String id);
}
