package com.cxsw.web.pojo;


public class Shop {
	private Integer id;
	private String province;
	private String  city;
	private String country;
	private String detail_address;
	private String name;
	private String img;
	private String comment;
	private Integer state;
	public Shop(Integer id, String province, String city, String country, String detail_address, String name,
			String img, String comment, Integer state) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.country = country;
		this.detail_address = detail_address;
		this.name = name;
		this.img = img;
		this.comment = comment;
		this.state = state;
	}
	public Shop() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
		return "Shop [id=" + id + ", province=" + province + ", city=" + city + ", country=" + country
				+ ", detail_address=" + detail_address + ", name=" + name + ", img=" + img + ", comment="
				+ comment + ", state=" + state + "]";
	}
	

}
