package com.StarBucks.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Cart;
import com.StarBucks.bean.Goods;
import com.StarBucks.dao.CartDao;

@Service
public class CartService {
	@Autowired
	CartDao Cd;
	public List<Cart> FindAll(Integer id){
		return Cd.FindAll(id);
	}
	public Cart FindById(Integer id) {
		return Cd.FindById(id);
	}
	public List<Goods> FindAllGoods(Integer id){
		return Cd.FindAllGoods(id);
	}
	public void UpdateNum(Integer num,Integer id) {
		Cd.UpdateNum(num, id);
	}
	public void erase(Integer id) {
		Cd.erase(id);
	}
	public void insert(Cart c) {
		Cd.insert(c);
	}
	public Cart FindByGCId(Integer gid,Integer cid) {
		return Cd.FindByGCId(gid, cid);
	}
	public Goods FindByCaCId(Integer Caid,Integer cid) {
		return Cd.FindByCaCId(Caid, cid);
	}
}
