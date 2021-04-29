package com.StarBucks.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StarBucks.bean.*;
import com.StarBucks.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService Cs;
	
	@RequestMapping("/custom/Cart")
	public void Cart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Custom c = (Custom)(req.getSession().getAttribute("custom"));
		List<Cart> cartList = Cs.FindAll(c.getUser_id());
		List<Goods> goodlist =Cs.FindAllGoods(c.getUser_id());
		Integer size = cartList.size();
		if(size==0) req.setAttribute("info", "购物车里无商品,快去添加吧!");
		req.setAttribute("size", size);
		req.setAttribute("CartList", cartList);
		req.setAttribute("GoodList", goodlist);
		req.getRequestDispatcher("/Cart.jsp").forward(req, resp);
	}
	
	@RequestMapping("/custom/addCart")
	public void addCart(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String goodsId = req.getParameter("goodsId");
		String num = req.getParameter("num");
		Custom c = (Custom)(req.getSession().getAttribute("custom"));
		Cart cart = Cs.FindByGCId(Integer.valueOf(goodsId), Integer.valueOf(c.getUser_id()));
		if(cart!=null) {
			Cs.UpdateNum(Integer.valueOf(num)+cart.getNum(), cart.getId());
		}else {
			cart = new Cart();
			cart.setCustom_id(c.getUser_id());
			cart.setGoods_id(Integer.valueOf(goodsId));
			cart.setNum(Integer.valueOf(num));
			Cs.insert(cart);
		}
		req.getRequestDispatcher("/custom/Cart.do").forward(req, resp);
	}
	@RequestMapping("/custom/DeleteCartItem")
	public void DeleteCartItem(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cartid = req.getParameter("cartid");
		Cs.erase(Integer.valueOf(cartid));
		req.getRequestDispatcher("/custom/Cart.do").forward(req, resp);
	}
	@RequestMapping("/custom/ReNum")
	public void ReNum(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cartid = req.getParameter("cartid");
		Cart c = Cs.FindById(Integer.valueOf(cartid));
		if((c.getNum()-1)==Integer.valueOf(0)) {
			Cs.erase(c.getId());
		}
		else Cs.UpdateNum(c.getNum()-1, c.getId());
		req.getRequestDispatcher("/custom/Cart.do").forward(req, resp);
	}
	@RequestMapping("/custom/AddNum")
	public void AddNum(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String cartid = req.getParameter("cartid");
		Cart c = Cs.FindById(Integer.valueOf(cartid));
		Cs.UpdateNum(c.getNum()+1, c.getId());
		req.getRequestDispatcher("/custom/Cart.do").forward(req, resp);
	}
}
