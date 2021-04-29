package com.StarBucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StarBucks.bean.Custom;
import com.StarBucks.dao.CustomDao;

@Service
public class CustomService {
	@Autowired
	CustomDao Cd;
	public Custom search(String user_name) {
		return Cd.search(user_name);
	}
	public void register(Custom c) {
		Cd.register(c);
	}
}
