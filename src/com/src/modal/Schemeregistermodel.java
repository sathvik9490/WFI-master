package com.src.modal;

public class Schemeregistermodel {
private String scheme;
private String image;
public Schemeregistermodel(String string,String string2) {
	this.setScheme(string);
	this.setImage(string2);
}
public Schemeregistermodel() {
	
}
public String getScheme() {
	return scheme;
}

public void setScheme(String scheme) {
	this.scheme = scheme;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
