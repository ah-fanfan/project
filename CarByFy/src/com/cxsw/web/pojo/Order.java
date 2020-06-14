package com.cxsw.web.pojo;

public class Order {
	private Integer id;
	private String user_idcard;
	private String user_name;
	private Integer car_id;
	private String car_code;
	private String car_name;
	private String shop_name;
	private String fetch_time;
	private String price;
	private String order_code;
	private String comment;
	private String state;


	public Order(Integer id, String user_idcard, String user_name, Integer car_id, String car_code, String car_name,
			String shop_name, String fetch_time, String price, String order_code, String comment, String state) {
		super();
		this.id = id;
		this.user_idcard = user_idcard;
		this.user_name = user_name;
		this.setCar_id(car_id);
		this.setCar_code(car_code);
		this.car_name = car_name;
		this.shop_name = shop_name;
		this.fetch_time = fetch_time;
		this.price = price;
		this.order_code = order_code;
		this.comment = comment;
		this.state = state;
	}
	public Order() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_idcard() {
		return user_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getFetch_time() {
		return fetch_time;
	}
	public void setFetch_time(String fetch_time) {
		this.fetch_time = fetch_time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_code() {
		return car_code;
	}
	public void setCar_code(String car_code) {
		this.car_code = car_code;
	}
	public Integer getCar_id() {
		return car_id;
	}
	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_idcard=" + user_idcard + ", user_name=" + user_name + ", car_id=" + car_id
				+ ", car_code=" + car_code + ", car_name=" + car_name + ", shop_name=" + shop_name + ", fetch_time="
				+ fetch_time + ", price=" + price + ", order_code=" + order_code + ", comment=" + comment + ", state="
				+ state + "]";
	}
	
	

}
