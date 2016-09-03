package com.shoppingCart.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shoppingCart.dao.entity.Product;
import com.shoppingCart.dao.entity.ProductWithImage;

public class ProductsDAO {
	private static SessionFactory factory;
	private static ProductsDAO mngProd;
	static{
		try{
		factory = new Configuration().configure().
		addPackage("com.shoppingCart.dao.entity") //add package if used.
				//addAnnotatedClass(Product.class).
				.buildSessionFactory();
		}
		catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public synchronized static ProductsDAO getInstance(){
		mngProd = new ProductsDAO();
		return mngProd;
	}
	
	public static void main(String[] args) throws IOException {
		try {
			factory = new Configuration().configure().
			// addPackage("com.xyz") //add package if used.
					addAnnotatedClass(Product.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ProductsDAO mngProd = new ProductsDAO();
		/*File file = new File("C:\\mavan-hibernate-image-mysql.gif");
        byte[] bFile = new byte[(int) file.length()];

        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
	     */
		 File file = new File("C:\\Users\\Raul\\Desktop\\Photo.png");
		 byte[] bFile = new byte[(int) file.length()];
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close(); 
	     
		mngProd.addProduct("Xperia M", 30000);
		mngProd.addProduct("Xperia MR", 39000);
		mngProd.addProduct("Nexus 5x", 25000);
		System.out.println("Success");
		
		byte[] data = new byte[]{1,0};
		try{
		mngProd.addProductWithImage(new ProductWithImage("nn", 123, data));
		}
		catch(Exception e0){
			System.out.println(e0.getMessage());
		}
		System.out.println("Finished");
	}
	
	   public Integer addProduct(String productName, int cost){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer productId = null;
		      try{
		         tx = session.beginTransaction();
		         Product prod = new Product();
		         prod.setProductName(productName);
		         prod.setCost(cost);
		         productId = (Integer) session.save(prod); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      System.out.println(productId);
		      return productId;
		   }
	   
	   public Integer addProductWithImage(ProductWithImage product){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer productId = null;
		      try{
		         tx = session.beginTransaction();
		         productId = (Integer) session.save(product); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      System.out.println(productId);
		      return productId;
		   }
	   
	   public List viewProductsList(){
		   return null;
	   }
}
