package com.StarBucks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StarBucks.bean.Cart;
import com.StarBucks.bean.Custom;
import com.StarBucks.bean.Goods;
import com.StarBucks.bean.OrderItem;
import com.StarBucks.service.*;

@Controller
public class OrderConfirmController {
	@Autowired
	OrderConfirmService Ocs;
	@Autowired
	CartService Cs;
	@RequestMapping("/custom/order_confirm")
	public void order_confirm(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException  {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String[] items = req.getParameterValues("itemid");
		/*for(String id:items) {
			System.out.println(id);
		}*/
		String url= "";
		if(items==null) {
			url = "/custom/Cart.do";
		}else {
			List<Cart> cartList = new ArrayList<Cart>();
			List<Goods> goodList = new ArrayList<Goods>();
			Double s = Double.valueOf(0);
			Custom cu = (Custom)req.getSession().getAttribute("custom"); 
			for(String id:items) {
				Cart cart = Cs.FindById(Integer.valueOf(id));
				cartList.add(cart);
				Goods c1 = Cs.FindByCaCId(Integer.valueOf(id), cu.getUser_id());
				//System.out.println(c1.toString());
				goodList.add(c1);
				s += cart.getNum()*c1.getPrice();
				Cs.erase(Integer.valueOf(id));
			}
			String OrderId = OrderItem.createOrderId();
			for(Cart ca:cartList) {
				OrderItem Of = new OrderItem();
				Of.setGoodsId(ca.getGoods_id());
				Of.setNum(ca.getNum());
				Of.setOrderId(OrderId);
				Ocs.insert(Of);
			}
			req.setAttribute("CartList",cartList);
			req.setAttribute("GoodList", goodList);
			req.setAttribute("sum", String.format("%.2f", s));
			req.setAttribute("orderId", OrderId);
			url = "/Order_Confirm.jsp";
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
