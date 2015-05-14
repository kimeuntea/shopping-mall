package dao;

import java.sql.Timestamp;

public class MemberBean {
private String id;
private String pwd;
private String name;
private String email;
private String zipcode;
private String address;
private String phone;
private String useyn;
private Timestamp date;
public MemberBean() {
	// TODO Auto-generated constructor stub
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getUseyn() {
	return useyn;
}
public void setUseyn(String useyn) {
	this.useyn = useyn;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}

}
