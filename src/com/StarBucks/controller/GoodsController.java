package com.StarBucks.controller;

import java.io.File;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.StarBucks.bean.Goods;
import com.StarBucks.bean.Goods_Type;
import com.StarBucks.bean.Page;
import com.StarBucks.service.GoodsService;
import com.StarBucks.service.Goods_TypeService;


@Controller
public class GoodsController {
	@Autowired
	GoodsService Gs;
	@Autowired
	Goods_TypeService GTs;
	@RequestMapping("menu")
	public void Menu(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String pageNo = req.getParameter("pageNo");
		if (pageNo == null || pageNo.length() == 0) {
			pageNo = "1";
		}
		Page page = new Page();
		List<Goods> goods = Gs.FindAll();
		req.setAttribute("goods", goods);
		Integer totalRecord = goods.size();
		Integer pages = (totalRecord%9!=0)?(totalRecord/9+1):(totalRecord/9);
		page.setCurrentPageNo(Integer.valueOf(pageNo));
		page.setPageSize(9);
		page.setTotalPages(pages);
		page.setTotalRecord(totalRecord);
		req.setAttribute("page", page);
		Integer start = (Integer.valueOf(pageNo)-1)*page.getPageSize();
		Integer end = (Integer.valueOf(pageNo))*page.getPageSize()>page.getTotalRecord()?page.getTotalRecord():((Integer.valueOf(pageNo))*page.getPageSize());
		List<Goods_Type> goods_type = GTs.FindAll();
		req.setAttribute("goods_type", goods_type);
		req.setAttribute("PageStart", start);
		if((end-1)<Integer.valueOf(0)) {
			end=0;
		}else end = end-1;
		req.setAttribute("PageEnd", end);
		req.setAttribute("pageno", page.getCurrentPageNo());
		req.setAttribute("pages", pages);
		req.getRequestDispatcher("Menu.jsp").forward(req, resp);
	}
	@RequestMapping("menuByType")
	public void MenuByType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String pageNo = req.getParameter("pageNo");
		if (pageNo == null || pageNo.length() == 0) {
			pageNo = "1";
		}
		Page page = new Page();
		String type = req.getParameter("type");
		List<Goods> goods = Gs.ByType(Integer.valueOf(type));
		req.setAttribute("goods", goods);
		Integer totalRecord = goods.size();
		Integer pages = (totalRecord%9!=0)?(totalRecord/9+1):(totalRecord/9);
		page.setCurrentPageNo(Integer.valueOf(pageNo));
		page.setPageSize(9);
		page.setTotalPages(pages);
		page.setTotalRecord(totalRecord);
		req.setAttribute("page", page);
		Integer start = (Integer.valueOf(pageNo)-1)*page.getPageSize();
		Integer end = (Integer.valueOf(pageNo))*page.getPageSize()>page.getTotalRecord()?page.getTotalRecord():((Integer.valueOf(pageNo))*page.getPageSize());
		List<Goods_Type> goods_type = GTs.FindAll();
		req.setAttribute("goods_type", goods_type);
		req.setAttribute("PageStart", start);
		if((end-1)<Integer.valueOf(0)) {
			end=0;
		}else end = end-1;
		req.setAttribute("PageEnd", end);
		req.setAttribute("pageno", page.getCurrentPageNo());
		req.setAttribute("pages", pages);
		req.getRequestDispatcher("Menu.jsp").forward(req, resp);
	}
	@RequestMapping("GoodsDetails")
	public void GoodsDetails(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String goodId = req.getParameter("goodId");
		Goods OneGood = Gs.ByGoodId(Integer.valueOf(goodId));
		Goods_Type GoodType  = GTs.TypeNameById(Integer.valueOf(goodId));
		req.setAttribute("OneGood", OneGood);
		req.setAttribute("goodtype", GoodType);
		req.getRequestDispatcher("Good_Details.jsp").forward(req, resp);
	}
	@RequestMapping("/business/Goodsadd")
	public void GoodsAdd(HttpServletRequest req,HttpServletResponse resp,MultipartFile goodsimg,Goods goods) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//System.out.println(goods);
		String appPath = req.getServletContext().getRealPath("/");
		//System.out.println(goodsimg.getName());
		// 实际的上传路径
		String path = appPath + "image/goodsimg" + File.separator;
		//System.out.println(path);
		// 使用当前时间作为文件名
		// 获取当前时间，使用当前时间作为文件名
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // 设置当前时间的字符串格式
		// 生成文件名
		String filename = sdf.format(d) + ".jpg";
		
		//新建一个文件
		File newFile =  new File(path,filename);
		goodsimg.transferTo(newFile);//将上传文件数据保存到指定的file中
		goods.setItem_img(filename);
		goods.setStatus(1);
		Gs.insert(goods);
		//System.out.println(goods);
		resp.getWriter().write("success");
	}
}
