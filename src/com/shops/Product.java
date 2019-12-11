package com.shops;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Product {
	
	int sid;
	int pid;	
	String prodName;
	double price;
	//Getter and Setters
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSid() {
		return sid;
	}
	public int getPid() {
		return pid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	


}