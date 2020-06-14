package com.cxsw.web.pojo;



public class Car {
	private Integer id;
	private String mark;
	private String kind;
	private String name;
	private String conf_style;
	private Integer seat_num;
	private Integer door_num;
	private String outimg;
	private String inimg;
	private String fuel_type;
	private String transmission_type;
	private String seat_material;
	private Integer havenavigation;
	private Integer havetopwindow;
	private float price;
	private Integer comment;
	private Integer state;
	
	public Car(Integer id, String mark, String kind, String name, String conf_style, Integer seat_num,
			Integer door_num, String outimg, String inimg, String fuel_type, String transmission_type,
			String seat_material, Integer havenavigation, Integer havetopwindow, float price, Integer comment,
			Integer state) {
		super();
		this.id = id;
		this.mark = mark;
		this.kind = kind;
		this.name = name;
		this.conf_style = conf_style;
		this.seat_num = seat_num;
		this.door_num = door_num;
		this.outimg = outimg;
		this.inimg = inimg;
		this.fuel_type = fuel_type;
		this.transmission_type = transmission_type;
		this.seat_material = seat_material;
		this.havenavigation = havenavigation;
		this.havetopwindow = havetopwindow;
		this.price = price;
		this.comment = comment;
		this.state = state;
	}
	public Car() {
		super();
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", kind=" + kind +  ", name=" + name
				+ ", conf_style=" + conf_style + ", seat_num=" + seat_num + ", door_num=" + door_num + ", outimg="
				+ outimg + ", inimg=" + inimg + ", fuel_type=" + fuel_type + ", transmission_type=" + transmission_type
				+ ", seat_material=" + seat_material + ", havenavigation=" + havenavigation + ", havetopwindow="
				+ havetopwindow + ", price=" + price + ", comment=" + comment + ", state=" + state + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getConf_style() {
		return conf_style;
	}
	public void setConf_style(String conf_style) {
		this.conf_style = conf_style;
	}
	public Integer getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(Integer seat_num) {
		this.seat_num = seat_num;
	}
	public Integer getDoor_num() {
		return door_num;
	}
	public void setDoor_num(Integer door_num) {
		this.door_num = door_num;
	}
	public String getOutimg() {
		return outimg;
	}
	public void setOutimg(String outimg) {
		this.outimg = outimg;
	}
	public String getInimg() {
		return inimg;
	}
	public void setInimg(String inimg) {
		this.inimg = inimg;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public String getTransmission_type() {
		return transmission_type;
	}
	public void setTransmission_type(String transmission_type) {
		this.transmission_type = transmission_type;
	}
	public String getSeat_material() {
		return seat_material;
	}
	public void setSeat_material(String seat_material) {
		this.seat_material = seat_material;
	}
	public Integer getHavenavigation() {
		return havenavigation;
	}
	public void setHavenavigation(Integer havenavigation) {
		this.havenavigation = havenavigation;
	}
	public Integer getHavetopwindow() {
		return havetopwindow;
	}
	public void setHavetopwindow(Integer havetopwindow) {
		this.havetopwindow = havetopwindow;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
