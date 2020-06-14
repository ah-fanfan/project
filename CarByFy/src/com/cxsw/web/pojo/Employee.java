package com.cxsw.web.pojo;

public class Employee {
	private Integer id;
	private String  emp_code;
	private String emp_name;
	private Integer emp_age;
	private String emp_sex;
	private String emp_dep;
	private String emp_phone;
	private String emp_idcard;
	private String emp_address;
	private String emp_img;
	private String comment;
	private Integer state;
	private String province;
	private String city;
	private String area;
	public Employee(Integer id, String emp_code, String emp_name, Integer emp_age, String emp_sex, String emp_dep,
			String emp_phone, String emp_idcard, String emp_address, String emp_img, String comment, Integer state) {
		super();
		this.id = id;
		this.emp_code = emp_code;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_sex = emp_sex;
		this.emp_dep = emp_dep;
		this.emp_phone = emp_phone;
		this.emp_idcard = emp_idcard;
		this.emp_address = emp_address;
		this.emp_img = emp_img;
		this.comment = comment;
		this.state = state;
	}
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_sex() {
		return emp_sex;
	}
	public void setEmp_sex(String emp_sex) {
		this.emp_sex = emp_sex;
	}
	public String getEmp_dep() {
		return emp_dep;
	}
	public void setEmp_dep(String emp_dep) {
		this.emp_dep = emp_dep;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_idcard() {
		return emp_idcard;
	}
	public void setEmp_idcard(String emp_idcard) {
		this.emp_idcard = emp_idcard;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_code=" + emp_code + ", emp_name=" + emp_name + ", emp_age=" + emp_age
				+ ", emp_sex=" + emp_sex + ", emp_dep=" + emp_dep + ", emp_phone=" + emp_phone + ", emp_idcard="
				+ emp_idcard + ", emp_address=" + emp_address + ", emp_img=" + emp_img + ", comment=" + comment
				+ ", state=" + state + ", province=" + province + ", city=" + city + ", area=" + area + "]";
	}
	
	

}
