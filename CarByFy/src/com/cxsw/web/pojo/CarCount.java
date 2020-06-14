package com.cxsw.web.pojo;

public class CarCount {
	private Integer car_id;
	private Integer id;
	private Integer num;
	private String mark;
	private String name;
	public CarCount(Integer car_id, Integer id, Integer num, String mark, String name) {
		super();
		this.car_id = car_id;
		this.id = id;
		this.num = num;
		this.mark = mark;
		this.name = name;
	}
	public CarCount() {
		super();
	}
	@Override
	public String toString() {
		return "CarCount [car_id=" + car_id + ", id=" + id + ", num=" + num + ", mark=" + mark + ", name=" + name + "]";
	}
	public Integer getCar_id() {
		return car_id;
	}
	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
