package com.cxsw.web.pojo.liandong;

public class Province {
	private Integer id;
	private String provinceid;
	private String province;
	public Province(Integer id, String provinceid, String province) {
		super();
		this.id = id;
		this.provinceid = provinceid;
		this.province = province;
	}
	public Province() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceid=" + provinceid + ", province=" + province + "]";
	}
	
	

}
