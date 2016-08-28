package com.shoppingCart.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
   @Id @GeneratedValue
   @Column(name = "product_id")
   private int productId;

   @Column(name = "product_name")
   private String productName;

   @Column(name = "cost")
   private int cost;  

   public Product() {}
   public int getId() {
      return productId;
   }
   public void setId( int id ) {
      this.productId = id;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName( String productName ) {
      this.productName = productName;
   }
   public int getCost() {
      return cost;
   }
   public void setCost( int cost ) {
      this.cost = cost;
   }
}