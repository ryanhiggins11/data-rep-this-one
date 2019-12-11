package com.shops;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;





@ManagedBean
@SessionScoped
public class StoreProductController {

	DAO dao;
	ArrayList<StoreProduct> storeProducts;
	
	public StoreProductController(){
		super();
		try {
			dao = new DAO();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	public String loadStoreProducts(int spId) {
		System.out.println("In loadStoreProducts()");
		try {
			storeProducts = dao.loadStoreProducts(spId);
			return "storeProducts";
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<StoreProduct> getStoreProducts() {
		return storeProducts;
	}
	
}
