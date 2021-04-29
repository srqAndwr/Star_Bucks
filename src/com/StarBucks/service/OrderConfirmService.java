package com.StarBucks.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.OrderItem;
import com.StarBucks.dao.OrderConfirmDao;

@Service
public class OrderConfirmService {
	@Autowired
	OrderConfirmDao Ocd;
	public void insert(OrderItem o) {
		Ocd.insert(o);
	}
	public List<OrderItem> FindAllByOrderId(String Id){
		return Ocd.FindAllByOrderId(Id);
	}
	public void delOrderItem(String Id) {
		Ocd.delOrderItem(Id);
	}
}
