package com.StarBucks.controller;

import java.io.IOException;

import java.io.PrintWriter;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StarBucks.bean.Business;
import com.StarBucks.bean.Custom;
import com.StarBucks.service.BusinessService;
import com.StarBucks.service.CustomService;

@Controller
public class CustomController {
	@Autowired
	CustomService Cs;
	@Autowired
	BusinessService Bs;
	@RequestMapping("customlogin")
	public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//System.out.println("已进入");
		PrintWriter pw = resp.getWriter();
		String v_code = String.valueOf(req.getSession().getAttribute("CheckCode"));
		String user_code = req.getParameter("user_v").trim().toUpperCase();
		//System.out.println(user_code+"    "+v_code);
		String info="";
		if(v_code.equals(user_code)) {
			String user_name = req.getParameter("user_name");
			String user_paw = req.getParameter("user_paw");
				Custom c = Cs.search(user_name);
				if(c!=null) {
					//System.out.println(c);
					if(c.getUser_paw().equals(user_paw)) {
						pw.write("indexCustom.jsp");
						req.getSession().setAttribute("custom", c);
					}else {
						pw.write("paw error");
						info = "密码错误";
					}
				}else {
					pw.write("user not exit");
					info = "用户不存在";
				}
			
		}else {
			pw.write("code error");
			info = "验证码错误";
		}
		req.setAttribute("info", info);
	}
	@RequestMapping("register")
	public void register(HttpServletRequest req,HttpServletResponse resp) throws IOException, ParseException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		String v_code = String.valueOf(req.getSession().getAttribute("CheckCode"));
		String user_code = req.getParameter("user_v").trim().toUpperCase();
		if(v_code.equals(user_code)) {
			String sex = req.getParameter("user_sex").trim();
			String user_name = req.getParameter("user_name");
			String user_paw = req.getParameter("user_paw");
			Custom c = Cs.search(user_name);
			if(c!=null) {
				pw.write("user exit");
			}else {
				c = new Custom();
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
				String d2 = dateFormat.format(date).toString();
				Date d1= dateFormat.parse(d2);
				c.setRegdate(d1);
				if(sex.equals("nan")) c.setSex("男");
				else c.setSex("女");
				//System.out.println(c.getSex());
				c.setUser_name(user_name);
				c.setUser_paw(user_paw);
				c.setStatus(1);
				Cs.register(c);
				req.getSession().setAttribute("custom", c);
				pw.write("success");
			}
		}else {
			pw.write("code error");
		}
	}
	@RequestMapping("Logout")
	public void Logout(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect("indexCustom.jsp");
	}
}
