package com.shoppingCart.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.shoppingCart.dao.entity.Product;
import com.shoppingCart.dao.entity.ProductWithImage;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class TestProductsDao {
	private static SessionFactory factory;
	private static ProductsDAO mngProd = ProductsDAO.getInstance();
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Raul\\Desktop\\Photo.png");
		FileInputStream stream = new FileInputStream(file);
		byte[] photo = new byte[65456];
		stream.read(photo);
		String photoData = Base64.encode(photo);
		stream.close();
		Product prod = new Product();
		prod.setProductName("Iphone");
		prod.setCost(34000);
		prod.setImageByteData(photoData.toCharArray());
		mngProd.addProduct(prod);
		
		prod.setProductName("Nexus 6p");
		mngProd.addProduct(prod);
		
		prod.setProductName("HTC");
		mngProd.addProduct(prod);
	}
}
