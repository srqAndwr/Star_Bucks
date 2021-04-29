package com.StarBucks.bean;

public class Goods {
	private Integer item_id;
	private String item_name;
	private Double price;
	private String item_img;
	private String details;
	private Integer status;
	private Integer type;
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Goods [item_id=" + item_id + ", item_name=" + item_name + ", price=" + price + ", item_img=" + item_img
				+ ", details=" + details + ", status=" + status + ", type=" + type + "]";
	}
	
}
