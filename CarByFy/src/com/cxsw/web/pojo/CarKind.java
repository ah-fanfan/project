package com.cxsw.web.pojo;

public class CarKind {
	private Integer id;
	private String kind_name;
	private String comment;
	private Integer state;
	public CarKind(Integer id, String kind_name, String comment, Integer state) {
		super();
		this.id = id;
		this.kind_name = kind_name;
		this.comment = comment;
		this.state = state;
	}
	public CarKind() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
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
		return "CarKind [id=" + id + ", kind_name=" + kind_name + ", comment=" + comment + ", state=" + state + "]";
	}
		
	

}
