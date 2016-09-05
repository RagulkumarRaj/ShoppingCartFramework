package com.shoppingCart.dao.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "PRODUCTWITHIMAGE")
public class ProductWithImage{
	public ProductWithImage(String productName, int cost, byte[] imageByteData) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.imageByteData = imageByteData;
	}

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "cost")
	private int cost;

	@Column(name = "image", unique = false, nullable = false, length = 100000)
	@Lob
	private byte[] imageByteData;

	//private MultipartFile multiPartFileData;

	public ProductWithImage() {
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public byte[] getImageByteData() {
		return imageByteData;
	}

	public void setImageByteData(byte[] imageByteData) {
		this.imageByteData = imageByteData;
	}

	/*
	public void setImageByteDataFromMultipart() {
		byte[] fileData;
		try {
			fileData = multiPartFileData.getBytes();
			setImageByteData(fileData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
/*
	public MultipartFile getMultiPartFileData() {
		return multiPartFileData;
	}

	public void setMultiPartFileData(MultipartFile multiPartFileData) {
		this.multiPartFileData = multiPartFileData;
	}
	*/
}
