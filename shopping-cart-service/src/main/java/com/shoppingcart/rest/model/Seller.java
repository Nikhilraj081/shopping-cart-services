package com.shoppingcart.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	private String sellerName;
	private String sellerAddress;

	public Seller(int sellerId, String sellerName, String sellerAddress) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
	}

	public Seller() {
		super();
		
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

}
