package com.StarBucks.dao;

import org.apache.ibatis.annotations.Param;

import com.StarBucks.bean.*;

public interface BusinessDao {
	Business search(@Param("user_name")String user_name);
}
