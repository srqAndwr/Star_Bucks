package com.StarBucks.dao;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.Custom;

public interface CustomDao {
	Custom search(@Param("user_name")String user_name);
	void register(@Param("user")Custom c);
}
