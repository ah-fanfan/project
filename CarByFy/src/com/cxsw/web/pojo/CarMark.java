package com.cxsw.web.pojo;

public class CarMark {
	private Integer id;
	private String car_mark;
	private String img;
	private String comment;
	private Integer state;
	public CarMark(Integer id, String car_mark, String img, String comment, Integer state) {
		super();
		this.id = id;
		this.car_mark = car_mark;
		this.img = img;
		this.comment = comment;
		this.state = state;
	}
	public CarMark() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCar_mark() {
		return car_mark;
	}
	public void setCar_mark(String car_mark) {
		this.car_mark = car_mark;
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
		return "CarMark [id=" + id + ", car_mark=" + car_mark + ", img=" + img + ", comment=" + comment + ", state="
				+ state + "]";
	}
	
	

}
