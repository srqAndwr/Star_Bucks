package com.StarBucks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.Cart;
import com.StarBucks.bean.Goods;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface CartDao {
	List<Cart> FindAll(@Param("CId")Integer id);
	Cart FindById(@Param("CId")Integer id);
	List<Goods> FindAllGoods(@Param("CId")Integer id);
	void UpdateNum(@Param("num")Integer num,@Param("id")Integer id);
	void erase(@Param("id")Integer id);
	void insert(@Param("c")Cart cart);
	Cart FindByGCId(@Param("GId")Integer id,@Param("CId")Integer cid);
	Goods FindByCaCId(@Param("CaId")Integer id,@Param("CId")Integer cid);
}
