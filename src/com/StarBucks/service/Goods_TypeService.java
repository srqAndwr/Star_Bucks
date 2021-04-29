package com.StarBucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Goods_Type;
import com.StarBucks.dao.Goods_TypeDao;

@Service
public class Goods_TypeService {
	@Autowired
	Goods_TypeDao GTd;
	public List<Goods_Type> FindAll(){
		return GTd.FindAll();
	}
	public Goods_Type TypeNameById(Integer Id) {
		return GTd.TypeNameById(Id);
	}
}
