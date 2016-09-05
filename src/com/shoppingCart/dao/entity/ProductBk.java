package com.shoppingCart.dao.entity;

import javax.persistence.*;

import com.sun.org.apache.xml.internal.security.utils.Base64;

@Entity
@Table(name = "PRODUCT")
public class ProductBk {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_cost")
	private int productCost;

	@Column(name = "image", unique = false, nullable = false, length = 100000)
	@Lob
	private byte[] imageByteData;

	public ProductBk() {
	}

	/*
	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}
*/
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setCost(int productCost) {
		this.productCost = productCost;
	}

	public byte[] getImageByteData() {
		return imageByteData;
	}

	public void setImageByteData(byte[] imageByteData) {
		this.imageByteData = imageByteData;
	}
}