package com.StarBucks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StarBucks.bean.Branch;
import com.StarBucks.service.BranchService;

@Controller
public class BranchController {
	@Autowired
	BranchService Bas;
	@RequestMapping("/branch")
	public void Branch(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<Branch> li = Bas.FindAll();
		req.setAttribute("branch_list", li);
		req.getRequestDispatcher("Branch.jsp").forward(req, resp);
	}
	@RequestMapping("/branchByArea")
	public void BranchByArea(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String area = String.valueOf(req.getParameter("area")).trim();
		//System.out.println(area);
		List<Branch> li = Bas.ByArea(area);
		/*for(Branch b:li) {
			System.out.println(b.getBranch_id()+" "+b.getBranch_name());
		}*/
		if(li.size()==0) {
			req.setAttribute("size", 0);
		}else req.setAttribute("size", 1);
		req.setAttribute("branch_list", li);
		req.setAttribute("area", area);
		req.getRequestDispatcher("Branch.jsp").forward(req, resp);
	}
	@RequestMapping("/business/branchManager")
	public void branchManager(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<Branch> li = Bas.FindAll();
		req.setAttribute("branch_list", li);
		req.getRequestDispatcher("/BranchManger.jsp").forward(req, resp);
	}
	@RequestMapping("/business/Branch_details")
	public void Branch_details(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("BranchId");
		Branch b = Bas.ById(Integer.valueOf(id));
		req.setAttribute("branch", b);
		req.getRequestDispatcher("/Branch_details.jsp").forward(req, resp);
	}
	@RequestMapping("/business/BranchDel")
	public void BranchDel(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Bas.del(Integer.valueOf(id));
		resp.getWriter().write("success");
	}
	@RequestMapping("/business/BranchUpdate")
	public void BranchUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String branchname = req.getParameter("branchname");
		String branchaddr = req.getParameter("branchaddr");
		String phone = req.getParameter("branchphone");
		Branch b = new Branch();
		b.setBranch_name(branchname);
		b.setBranch_id(Integer.valueOf(id));
		b.setBranch_addr(branchaddr);
		b.setPhone(phone);
		Bas.update(b);
		resp.getWriter().write("success");
	}
}
