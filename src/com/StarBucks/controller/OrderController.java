package com.StarBucks.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StarBucks.bean.*;
import com.StarBucks.service.OrderConfirmService;
import com.StarBucks.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService Os;
	@Autowired
	OrderConfirmService Ofs;
	
	@RequestMapping("/custom/AddorderToBePaid")
	public void AddOrderToBePaid(HttpServletRequest req,HttpServletResponse resp) throws ParseException, ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String order_id = req.getParameter("order_id");
		//System.out.println(req.getParameter("tatilsum"));
		Double sum = Double.valueOf(req.getParameter("tatilsum").toString());
		
		String address = req.getParameter("addr");
		String contacts = req.getParameter("contacts");
		String phone = req.getParameter("phone");
		Custom custom = (Custom)req.getSession().getAttribute("custom");
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d2 = dateFormat.format(date).toString();
		Date d1= dateFormat.parse(d2);
		Order o = new Order();
		o.setId(order_id);
		o.setCustom_Id(custom.getUser_id());
		o.setSum(sum);
		o.setPhone(phone);
		o.setContacts(contacts);
		o.setAddress(address);
		o.setOrderTime(d1);
		o.setStatus(Integer.valueOf(0));
		Os.insertToBePaid(o);
		req.getRequestDispatcher("/custom/orderToBePaid.do").forward(req, resp);
	}
	@RequestMapping("/custom/orderToBePaid")
	public void OrderToBePaid(HttpServletRequest req,HttpServletResponse resp) throws ParseException, ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//System.out.println("已进入未支付订单");
		Custom custom = (Custom)req.getSession().getAttribute("custom");
		List<Order> orderList = Os.FindToBePaid(custom.getUser_id());
		List<Integer> TitalNum = new ArrayList<Integer>();
		Integer size = orderList.size();
		String info = "";
		if(size<=0) {
			info = "暂无未支付订单";
		}else {
			info = "请尽快支付您的订单";
			for(Order o:orderList) {
				List<OrderItem> orderconfirmList = Ofs.FindAllByOrderId(o.getId());
				Integer s = 0;
				for(OrderItem of:orderconfirmList) {
					s += of.getNum();
				}
				TitalNum.add(s);
			}
		}
		String info1 = String.valueOf(req.getAttribute("info1"));
		//System.out.println("info1="+info1);
		if(info1.equals("删除成功")) {
			info = info1;
		}
		//System.out.println("info="+info);
		req.setAttribute("info", info);
		req.setAttribute("size", size);
		req.setAttribute("OrderList", orderList);
		req.setAttribute("TitalNum", TitalNum);
		req.getRequestDispatcher("/OrderTobepaid.jsp").forward(req, resp);
	}
	@RequestMapping("/custom/OrderPay")
	public void OrderPay(HttpServletRequest req,HttpServletResponse resp) throws ParseException, ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	//	System.out.println("已进入支付");
		String OrderId = req.getParameter("OrderId").trim();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d2 = dateFormat.format(date).toString();
		Date d1= dateFormat.parse(d2);
		Os.Pay(d1, OrderId);
		req.setAttribute("info", "支付成功");
		req.getRequestDispatcher("/custom/orderPaid.do").forward(req, resp);
	}
	@RequestMapping("/custom/delOrder")
	public void delOrder(HttpServletRequest req,HttpServletResponse resp) throws ParseException, ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//System.out.println("已进入删除");
		String OrderId = req.getParameter("OrderId").trim();
		//System.out.println("OrderId="+OrderId);
		Os.delOrder(OrderId);
		Ofs.delOrderItem(OrderId);
		req.setAttribute("info1", "删除成功");
		req.getRequestDispatcher("/custom/orderToBePaid.do").forward(req, resp);
	}
	@RequestMapping("/custom/orderPaid")
	public void OrderPaid(HttpServletRequest req,HttpServletResponse resp) throws ParseException, ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Custom custom = (Custom)req.getSession().getAttribute("custom");
		List<Order> orderList = Os.FindPaid(custom.getUser_id());
		List<Integer> TitalNum = new ArrayList<Integer>();
		Integer size = orderList.size();
		if(size<=0) {
			req.setAttribute("info", "暂无已支付订单");
		}else {
			for(Order o:orderList) {
				List<OrderItem> orderconfirmList = Ofs.FindAllByOrderId(o.getId());
				Integer s = 0;
				for(OrderItem of:orderconfirmList) {
					s += of.getNum();
				}
				TitalNum.add(s);
			}
		}
		req.setAttribute("size", size);
		req.setAttribute("OrderList", orderList);
		req.setAttribute("TitalNum", TitalNum);
		req.getRequestDispatcher("/OrderPaid.jsp").forward(req, resp);
	}
}
