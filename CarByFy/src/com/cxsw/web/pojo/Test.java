package com.cxsw.web.pojo;

public class Test {
	private Integer t_id;
	private String t_code;
	private String user_phone;
	private String user_name;
	private String t_car;
	private String t_shop;
	private String t_date;
	private String t_normal;
	private String comment;
	private Integer state;

	
	public Test(Integer t_id, String t_code, String user_phone, String user_name, String t_car, String t_shop,
			String t_date, String t_normal, String comment, Integer state) {
		super();
		this.t_id = t_id;
		this.t_code = t_code;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.t_car = t_car;
		this.t_shop = t_shop;
		this.t_date = t_date;
		this.t_normal = t_normal;
		this.comment = comment;
		this.state = state;
	}
	public Test() {
		super();
	}
	
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_code() {
		return t_code;
	}
	public void setT_code(String t_code) {
		this.t_code = t_code;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getT_car() {
		return t_car;
	}
	public void setT_car(String t_car) {
		this.t_car = t_car;
	}
	public String getT_shop() {
		return t_shop;
	}
	public void setT_shop(String t_shop) {
		this.t_shop = t_shop;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public String getT_normal() {
		return t_normal;
	}
	public void setT_normal(String t_normal) {
		this.t_normal = t_normal;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Test [t_id=" + t_id + ", t_code=" + t_code + ", user_phone=" + user_phone + ", user_name=" + user_name
				+ ", t_car=" + t_car + ", t_shop=" + t_shop + ", t_date=" + t_date + ", t_normal=" + t_normal
				+ ", comment=" + comment + ", state=" + state + "]";
	}
}
