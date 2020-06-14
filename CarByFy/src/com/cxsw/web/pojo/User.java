package com.cxsw.web.pojo;

public class User {
	private Integer id;
	private String user_name;
	private String user_psw;
	private String user_idcard;
	private String user_phone;
	private Integer user_age;
	private String user_sex;
	private String user_address;
	private String comment;
	private Integer state;
	public User(Integer id, String user_name, String user_psw, String user_idcard, String user_phone, Integer user_age,
			String user_sex, String user_address, String comment, Integer state) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_psw = user_psw;
		this.user_idcard = user_idcard;
		this.user_phone = user_phone;
		this.user_age = user_age;
		this.user_sex = user_sex;
		this.user_address = user_address;
		this.comment = comment;
		this.state = state;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_psw=" + user_psw + ", user_idcard=" + user_idcard
				+ ", user_phone=" + user_phone + ", user_age=" + user_age + ", user_sex=" + user_sex + ", user_address="
				+ user_address + ", comment=" + comment + ", state=" + state + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_psw() {
		return user_psw;
	}
	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}
	public String getUser_idcard() {
		return user_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Integer getUser_age() {
		return user_age;
	}
	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
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


}
