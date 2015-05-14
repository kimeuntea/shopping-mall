package dao;

import java.sql.Timestamp;

public class OrderBean {
private int odseq;//주문상세번호
private int oseq;//주문번호
private String id;//아이디
private Timestamp indate;//주문날짜
private String mname;//이름
private String zipNum;//주소
private String address;//주소
private String phone;//번호
private int pseq;//상품번호
private String pname;//상품이름
private int quantity;//수량
private int price2;//가격
private String result;//처리
public int getOdseq() {
	return odseq;
}
public void setOdseq(int odseq) {
	this.odseq = odseq;
}
public int getOseq() {
	return oseq;
}
public void setOseq(int oseq) {
	this.oseq = oseq;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Timestamp getIndate() {
	return indate;
}
public void setIndate(Timestamp indate) {
	this.indate = indate;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getZipNum() {
	return zipNum;
}
public void setZipNum(String zipNum) {
	this.zipNum = zipNum;
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
public int getPseq() {
	return pseq;
}
public void setPseq(int pseq) {
	this.pseq = pseq;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice2() {
	return price2;
}
public void setPrice2(int price2) {
	this.price2 = price2;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}

}
