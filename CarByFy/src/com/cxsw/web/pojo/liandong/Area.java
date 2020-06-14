package com.cxsw.web.pojo.liandong;

public class Area {
	private Integer id;
	private String cityid;
	private String areaid;
	private String areaname;
	public Area(Integer id, String cityid, String areaid, String area) {
		super();
		this.id = id;
		this.cityid = cityid;
		this.areaid = areaid;
		this.areaname = areaname;
	}
	public Area() {
		super();
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", cityid=" + cityid + ", areaid=" + areaid + ", areaname=" + areaname + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
}
