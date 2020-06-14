package com.cxsw.web.pojo.liandong;

public class City {
	private  Integer id;
	private String  provinceid;
	private String cityid;
	private String city;
	public City(Integer id, String provinceid, String cityid, String city) {
		super();
		this.id = id;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.city = city;
	}
	public City() {
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
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", provinceid=" + provinceid + ", cityid=" + cityid + ", city=" + city + "]";
	}
	

}
