package com.shoppingCart.dao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shoppingCart.dao.entity.Product;

public class ManageProducts {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().
			// addPackage("com.xyz") //add package if used.
					addAnnotatedClass(Product.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ManageProducts mngProd = new ManageProducts();
		mngProd.addProduct("Xperia M", 30000);
		mngProd.addProduct("Xperia MR", 39000);
		mngProd.addProduct("Nexus 5x", 25000);
		System.out.println("Success");
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
}
