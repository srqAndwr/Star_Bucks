package com.StarBucks.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Custom {
	private Integer user_id;
	private String user_name;
	private String user_paw;
	private String sex;
	private Date regdate;
	private Integer status;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_paw() {
		return user_paw;
	}
	public void setUser_paw(String user_paw) {
		this.user_paw = user_paw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Custom [user_id=" + user_id + ", user_name=" + user_name + ", user_paw=" + user_paw + ", sex=" + sex
				+ ", regdate=" + regdate + ", status=" + status + "]";
	}
	
	
}
