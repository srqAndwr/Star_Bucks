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

import com.StarBucks.bean.Branch;
import com.StarBucks.bean.Business;
import com.StarBucks.bean.Custom;
import com.StarBucks.bean.Goods;
import com.StarBucks.bean.Goods_Type;
import com.StarBucks.bean.Page;
import com.StarBucks.service.BranchService;
import com.StarBucks.service.BusinessService;
import com.StarBucks.service.GoodsService;
import com.StarBucks.service.Goods_TypeService;

@Controller
public class BussinessController {
	@Autowired
	BusinessService Bs;
	@Autowired
	GoodsService Gs;
	@Autowired
	Goods_TypeService Gts;
	@Autowired
	BranchService Bcs;
	
	@RequestMapping("businesslogin")
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// System.out.println("已进入");
		PrintWriter pw = resp.getWriter();
		String v_code = String.valueOf(req.getSession().getAttribute("CheckCode"));
		String user_code = req.getParameter("user_v").trim().toUpperCase();
		// System.out.println(user_code+" "+v_code);
		String info = "";
		if (v_code.equals(user_code)) {
			String user_name = req.getParameter("user_name");
			String user_paw = req.getParameter("user_paw");
			Business c = Bs.search(user_name);
			if (c != null) {
				if (c.getUser_paw().equals(user_paw)) {
					req.getSession().setAttribute("business", c);
					pw.write("business/indexBusiness.do");
				} else {
					info = "密码错误";
					pw.write("paw error");
				}
			} else {
				info = "用户不存在";
				pw.write("user not exit");
			}
		} else {
			pw.write("code error");
			info = "验证码错误";
		}
		req.setAttribute("info", info);
	}

	@RequestMapping("/business/indexBusiness")
	public void indexBusiness(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String flag = String.valueOf(req.getAttribute("flag"));
		if (flag.equals("search")) {
			List<Goods> li = (List<Goods>)req.getAttribute("goodList");
			if(li==null) req.setAttribute("info", "未找到该商品");
			else {
				List<Goods_Type> type = new ArrayList<Goods_Type>();
				for (Goods g : li) {
					Goods_Type gt = Gts.TypeNameById(g.getItem_id());
					type.add(gt);
				}
				req.setAttribute("typeList", type);
			}
		} else {
			String pageNo = req.getParameter("pageNo");
			if (pageNo == null || pageNo.length() == 0) {
				pageNo = "1";
			}
			Page page = new Page();
			List<Goods> goods = Gs.FindAllNos();
			if(goods==null) {
				req.setAttribute("info", "暂无任何商品");
			}
			List<Goods_Type> type = new ArrayList<Goods_Type>();
			for (Goods g : goods) {
				Goods_Type gt = Gts.TypeNameById(g.getItem_id());
				//System.out.println(gt.getType_name());
				type.add(gt);
			}
			req.setAttribute("typeList", type);
			req.setAttribute("goodList", goods);
			Integer totalRecord = goods.size();
			Integer pages = (totalRecord % 6 != 0) ? (totalRecord / 6 + 1) : (totalRecord / 6);
			page.setCurrentPageNo(Integer.valueOf(pageNo));
			page.setPageSize(6);
			page.setTotalPages(pages);
			page.setTotalRecord(totalRecord);
			req.setAttribute("page", page);
			Integer start = (Integer.valueOf(pageNo) - 1) * page.getPageSize();
			Integer end = (Integer.valueOf(pageNo)) * page.getPageSize() > page.getTotalRecord() ? page.getTotalRecord()
					: ((Integer.valueOf(pageNo)) * page.getPageSize());
			req.setAttribute("PageStart", start);
			if ((end - 1) < Integer.valueOf(0)) {
				end = 0;
			} else
				end = end - 1;
			req.setAttribute("PageEnd", end);
			req.setAttribute("pageno", page.getCurrentPageNo());
			req.setAttribute("pages", pages);
		}
		req.getRequestDispatcher("/indexBusiness.jsp").forward(req, resp);
	}

	@RequestMapping("/business/BusinessByName")
	public void BusinessByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("key").trim();
		List<Goods> goodList = new ArrayList<Goods>();
		if (Gs.ByGoodName(name) != null) {
			goodList.add(Gs.ByGoodName(name));
			req.setAttribute("goodList", goodList);
		}
		req.setAttribute("flag", "search");
		req.getRequestDispatcher("/business/indexBusiness.do").forward(req, resp);
	}
	@RequestMapping("/business/GoodsStatus")
	public void GoodsStatus(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String goodsId = req.getParameter("goodsId").trim();
		String status = req.getParameter("status");
		Gs.updateStatus(Integer.valueOf(goodsId), Integer.valueOf(status));
		req.getRequestDispatcher("/business/indexBusiness.do").forward(req, resp);
	}
	@RequestMapping("/business/GoodsUpdateS")
	public void GoodsUpdateS(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String goodsId = req.getParameter("goodsId").trim();
		Goods goods = Gs.ByGoodId(Integer.valueOf(goodsId));
		req.setAttribute("Goods", goods);
		req.getRequestDispatcher("/GoodsUpdate.jsp").forward(req, resp);
	}
	@RequestMapping("/business/GoodsUpdate")
	public void GoodsUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id=req.getParameter("id");
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");
		String details = req.getParameter("details");
		Gs.update(Integer.valueOf(id), Double.valueOf(price), details,goodsname);
		req.getRequestDispatcher("/business/indexBusiness.do").forward(req, resp);
	}
	@RequestMapping("/business/BranchAdd")
	public void BranchAdd(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String branchname=req.getParameter("branchname");
		String branchaddr = req.getParameter("branchaddr");
		String phone = req.getParameter("branchphone");
		Branch b = new Branch();
		//System.out.println(branchname+" "+branchaddr+" "+phone);
		b.setBranch_addr(branchaddr);
		b.setBranch_name(branchname);
		b.setPhone(phone);
		Bcs.insert(b);
		req.getRequestDispatcher("/branch.do").forward(req, resp);
	}
}
