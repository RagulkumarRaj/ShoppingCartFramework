package com.shoppingCart.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shoppingCart.dao.entity.Product;
import com.shoppingCart.dao.entity.ProductWithImage;

public class TestDAO {
public static void main(String[] args) {
	
}

private static SessionFactory factory;
private static ProductsDAO mngProd;
static {
	
	try {
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addPackage("com.shoppingCart.dao.entity") // add package if
															// used.
				// addAnnotatedClass(Product.class).
				.buildSessionFactory();
	} catch (Throwable ex) {
		System.err.println("Failed to create sessionFactory object." + ex);
		throw new ExceptionInInitializerError(ex);
	}
}

/**
 * Return a singleton instance of ProductDAO class
 * @return ProductsDAO
 */
public synchronized static ProductsDAO getInstance() {
	mngProd = new ProductsDAO();
	return mngProd;
}

/**
 * 
 * @param productName
 * @param cost
 * @return
 */
public Integer addProduct(Product product) {
	Session session = factory.openSession();
	Transaction tx = null;
	Integer productId = null;
	try {
		tx = session.beginTransaction();
		//Product prod = new Product();
		//prod.setProductName(productName);
		//prod.setCost(cost);
		productId = (Integer) session.save(product);
		new ArrayList().;
		tx.commit();
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		System.out.println(e.getMessage());
	} finally {
		session.close();
	}
	System.out.println(productId);
	return productId;
}

public Integer addProductWithImage(ProductWithImage product) {
	Session session = factory.openSession();
	Transaction tx = null;
	Integer productId = null;
	try {
		tx = session.beginTransaction();
		productId = (Integer) session.save(product);
		tx.commit();
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		System.out.println(e.getMessage());
	} finally {
		session.close();
	}
	System.out.println(productId);
	return productId;
}

public List<Product> viewProductsList() {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	String hql = "from Product";
	Query query = session.createQuery(hql);
	List<Product> results = query.list();
	tx.commit();
	session.close();
	return results;
}

}
