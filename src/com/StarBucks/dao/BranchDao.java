package com.StarBucks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.Branch;

public interface BranchDao {
	List<Branch> FindAll();
	List<Branch> ByArea(@Param("area")String area);
	void insert(@Param("branch")Branch b);
	Branch ById(@Param("Id")Integer id);
	void del(@Param("Id")Integer Id);
	void update(@Param("b")Branch b);
}
