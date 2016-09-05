package com.shoppingCart.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class ProductsDAOTest {
	private static SessionFactory factory;
	private static ProductsDAO mngProd;

	@Before
	public void setUp() throws Exception {
		factory = new Configuration().configure()
				//.addClass(Product.class).addClass(ProductWithImage.class)
				.addPackage("com.shoppingCart.dao.entity")
				.buildSessionFactory();
	}

	@Test
	public void testGetInstance() {
		mngProd = ProductsDAO.getInstance();
	}

	@Test
	public void testAddProduct() {
		File file = new File("C:\\Users\\Raul\\Desktop\\Photo.png");
		//mngProd.addProduct("Xperia M", 30000);
		//mngProd.addProduct("Xperia MR", 39000);
		//mngProd.addProduct("Nexus 5x", 25000);
	}

	public void testAddProductWithImage() {
		byte[] data = new byte[] { 1, 0 };
		//mngProd.addProductWithImage(new ProductWithImage("nn", 123, data));
		try {
			File file = new File("C:\\Users\\Raul\\Desktop\\Photo.png");
			FileInputStream fileStream = new FileInputStream(file);
			byte[] imageInfo = new byte[65356];
			fileStream.read(imageInfo);
			fileStream.close();
			//mngProd.addProductWithImage(new ProductWithImage("Asshole", 1230, imageInfo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewProductsList() {
		mngProd.viewProductsList();
	}

}
