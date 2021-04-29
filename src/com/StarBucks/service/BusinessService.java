package com.StarBucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Business;
import com.StarBucks.bean.Custom;
import com.StarBucks.dao.BusinessDao;

@Service
public class BusinessService {
	@Autowired
	BusinessDao Bd;
	public Business search(String user_name) {
		return Bd.search(user_name);
	}
}
