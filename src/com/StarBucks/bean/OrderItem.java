package com.StarBucks.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderItem {
	private Integer id;
	private String orderId;
	private Integer goodsId;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public static String createOrderId() {
		Date d=new Date();
		//��ǰʱ��������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssS");
		//100��999 ����λ�����
		int i=new Random().nextInt(899);
		//������:��ǰʱ��������+��λ�����
		String id=sdf.format(d)+String.valueOf(i+100);
		return id;
	}
	
	
}
