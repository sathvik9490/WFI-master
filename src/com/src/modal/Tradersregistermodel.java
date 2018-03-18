package com.src.modal;

public class Tradersregistermodel {
	private  String name;
	 private String uname;
	 private String pno;
	 private String locality;
	private  String address;
	 private String occupation;
	 private String products;
	 private String password;
	 private String image;
	 public Tradersregistermodel() {
			
		}
	 public Tradersregistermodel(String string1,String string2,String string3,String string4,String string5,String string6,String string7,String string8,String string9 ) {
		 this.setAddress(string5);
		 this.setImage(string9);
		 this.setLocality(string4);
		 this.setName(string1);
		 this.setOccupation(string6);
		 this.setPassword(string8);
		 this.setPno(string3);
		 this.setProducts(string7);
		 this.setUname(string2);
		 }	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
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
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
