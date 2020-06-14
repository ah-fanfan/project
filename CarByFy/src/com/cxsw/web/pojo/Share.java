package com.cxsw.web.pojo;

public class Share {
	private String fetch_time;
	private String kind;
	private float price;
	public Share(String fetch_time, String kind, float price) {
		super();
		this.fetch_time = fetch_time;
		this.kind = kind;
		this.price = price;
	}
	public Share() {
		super();
	}
	public String getFetch_time() {
		return fetch_time;
	}
	public void setFetch_time(String fetch_time) {
		this.fetch_time = fetch_time;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Share [fetch_time=" + fetch_time + ", kind=" + kind + ", price=" + price + "]";
	}
	

}
