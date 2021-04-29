package com.StarBucks.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Goods;
import com.StarBucks.dao.GoodsDao;

@Service
public class GoodsService {
	@Autowired
	GoodsDao Gd;
	public List<Goods> FindAll(){
		return Gd.FindAll();
	}
	public List<Goods> FindAllNos(){
		return Gd.FindAllNos();
	}
	public List<Goods> ByType(Integer type){
		return Gd.ByType(type);
	}
	public Goods ByGoodId(Integer goodId) {
		return Gd.ByGoodId(goodId);
	}
	public Goods ByGoodName(String goodName) {
		return Gd.ByGoodName(goodName);
	}
	public void updateStatus(Integer goodId,Integer status) {
		Gd.updateStatus(goodId, status);
	}
	public void update(Integer goodId,Double price,String details,String goodsname) {
		Gd.update(goodId, price, details,goodsname);
	}
	public void insert(Goods g) {
		Gd.insert(g);
	}
}
