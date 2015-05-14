package dao;

import java.sql.Timestamp;

public class CartBean {
private Integer cseq;
private String id;
private Integer pseq;
private Integer quantity;
private String result;
private String pname;
private String mname;
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
private Integer price1;
private Timestamp indate;
public Integer getCseq() {
	return cseq;
}
public void setCseq(Integer cseq) {
	this.cseq = cseq;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Integer getPseq() {
	return pseq;
}
public void setPseq(Integer pseq) {
	this.pseq = pseq;
}
public Integer getPrice1() {
	return price1;
}
public void setPrice1(Integer price1) {
	this.price1 = price1;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public Timestamp getIndate() {
	return indate;
}
public void setIndate(Timestamp indate) {
	this.indate = indate;
}

}
