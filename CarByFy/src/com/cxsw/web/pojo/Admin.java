package com.cxsw.web.pojo;

public class Admin {
	private Integer id;
	private String ad_code;
	private String ad_psw;;
	private Integer ad_power;
	private String ad_name;
	private Integer ad_age;
	private String img;
	private String ad_sex;
	private String ad_phone;
	private String province;
	private String city;
	private String area;
	private String ad_address;
	private String comment;
	private Integer state;
	
	public Admin() {
	}

	public Admin(Integer id, String ad_code, String ad_psw, Integer ad_power, String ad_name, Integer ad_age,
			String img, String ad_sex, String ad_phone, String province, String city, String area, String ad_address,
			String comment, Integer state) {
		super();
		this.id = id;
		this.ad_code = ad_code;
		this.ad_psw = ad_psw;
		this.ad_power = ad_power;
		this.ad_name = ad_name;
		this.ad_age = ad_age;
		this.img = img;
		this.ad_sex = ad_sex;
		this.ad_phone = ad_phone;
		this.province = province;
		this.city = city;
		this.area = area;
		this.ad_address = ad_address;
		this.comment = comment;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd_code() {
		return ad_code;
	}

	public void setAd_code(String ad_code) {
		this.ad_code = ad_code;
	}

	public String getAd_psw() {
		return ad_psw;
	}

	public void setAd_psw(String ad_psw) {
		this.ad_psw = ad_psw;
	}

	public Integer getAd_power() {
		return ad_power;
	}

	public void setAd_power(Integer ad_power) {
		this.ad_power = ad_power;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public Integer getAd_age() {
		return ad_age;
	}

	public void setAd_age(Integer ad_age) {
		this.ad_age = ad_age;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAd_sex() {
		return ad_sex;
	}

	public void setAd_sex(String ad_sex) {
		this.ad_sex = ad_sex;
	}

	public String getAd_phone() {
		return ad_phone;
	}

	public void setAd_phone(String ad_phone) {
		this.ad_phone = ad_phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAd_address() {
		return ad_address;
	}

	public void setAd_address(String ad_address) {
		this.ad_address = ad_address;
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
		return "Admin [id=" + id + ", ad_code=" + ad_code + ", ad_psw=" + ad_psw + ", ad_power=" + ad_power
				+ ", ad_name=" + ad_name + ", ad_age=" + ad_age + ", img=" + img + ", ad_sex=" + ad_sex + ", ad_phone="
				+ ad_phone + ", province=" + province + ", city=" + city + ", area=" + area + ", ad_address="
				+ ad_address + ", comment=" + comment + ", state=" + state + "]";
	}

	




}
