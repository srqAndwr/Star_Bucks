package com.StarBucks.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Custom;
import com.StarBucks.bean.Order;
import com.StarBucks.dao.OrderDao;

@Service
public class OrderService {
	@Autowired
	OrderDao Od;
	
	
	public List<Order> FindToBePaid(Integer id){
		return Od.FindToBePaid(id);
	}
	public List<Order> FindPaid(Integer id){
		return Od.FindPaid(id);
	}
	public void insertPaid(Order o) {
		Od.insertPaid(o);
	}
	public void insertToBePaid(Order o) {
		Od.insertToBePaid(o);
	}
	public Custom FindContacts(String id) {
		return Od.FindContacts(id);
	}
	public void Pay(Date time,String id) {
		Od.Pay(time, id);
	}
	public void delOrder(String id) {
		Od.delOrder(id);
	}
}
