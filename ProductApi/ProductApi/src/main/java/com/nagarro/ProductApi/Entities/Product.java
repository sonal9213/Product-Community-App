package com.nagarro.ProductApi.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Product {
	@Id
	@Column(unique = true)
	String productCode;
	String brand;
	String description;
	String productName;
	int price;
	int rating;
	String img;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Reviews> reviews = new ArrayList<Reviews>();
	
	
	
	public Product(String productCode, String brand, String description, String productName, int price, int rating,
			String img, List<Reviews> reviews) {
		super();
		this.productCode = productCode;
		this.brand = brand;
		this.description = description;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.img = img;
		this.reviews = reviews;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

}
