package com.StarBucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Branch;
import com.StarBucks.dao.BranchDao;

@Service
public class BranchService {
	@Autowired
	BranchDao Bd;
	public List<Branch> FindAll(){
		return Bd.FindAll();
	}
	public List<Branch> ByArea(String area){
		return Bd.ByArea('%'+area+'%');
	}
	public void insert(Branch b) {
		Bd.insert(b);
	}
	public Branch ById(Integer id) {
		return Bd.ById(id);
	}
	public void del(Integer Id) {
		Bd.del(Id);
	}
	public void update(Branch b) {
		Bd.update(b);
	}
}
