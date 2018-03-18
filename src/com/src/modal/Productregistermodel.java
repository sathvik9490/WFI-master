package com.src.modal;

public class Productregistermodel {
private String uname;
private String utype;
private String pname;
private String quantity;
private String price;
private String description;
private String locality;
private String address;
private String image;
public Productregistermodel() {
	
}

public Productregistermodel(String string1,String string2,String string3,String string4,String string5,String string6,String string7,String string8,String string9 ) {
 this.setUname(string1);
 this.setUtype(string2);
 this.setPname(string3);
 this.setQuantity(string4);
 this.setPrice(string5);
 this.setDescription(string6);
 this.setLocality(string7);
 this.setAddress(string8);
 this.setImage(string9);
 }	 
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUtype() {
	return utype;
}
public void setUtype(String utype) {
	this.utype = utype;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getLocality() {
	return locality;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}


}
