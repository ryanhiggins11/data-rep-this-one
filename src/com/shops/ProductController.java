package com.shops;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;


@ManagedBean
@SessionScoped
public class ProductController {
	
	DAO dao;
	ArrayList<Product> products;
	
	public ProductController() {
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	
	public String addProduct(Product p) {
		System.out.println(p.getPid() + " " + p.getSid());
		try {
			dao.addProduct(p);
			return "index";
		} catch (SQLIntegrityConstraintViolationException e) {
			FacesMessage message = 
					new FacesMessage("Error: Product ID exists");
					FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (CommunicationsException e) {
			FacesMessage message = 
					new FacesMessage("Error: Can't communicate with DataBase");
					FacesContext.getCurrentInstance().addMessage(null, message);
		}catch (Exception e) {
			FacesMessage message = 
					new FacesMessage("Error: " + e.getMessage());
					FacesContext.getCurrentInstance().addMessage(null, message);

			e.printStackTrace();
		}
		return null;
	}
	public void loadProducts() {
		System.out.println("In loadproducts()");
		try {
			products = dao.loadProducts();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void deleteProduct(int p) {
		try {
			dao.deleteProduct(p);	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
}