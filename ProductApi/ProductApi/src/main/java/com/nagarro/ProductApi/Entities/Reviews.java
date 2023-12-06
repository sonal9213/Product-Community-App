
package com.nagarro.ProductApi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int reviewCode;
	String msg;
	String heading;
    String userName;
    String ProductCode; 
	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	int rating;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Product product;
	@Column
	private boolean approve=false;

	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reviews(int reviewCode, String msg, String heading, String userName, int rating, Product product,
			boolean approve) {
		super();
		this.reviewCode = reviewCode;
		this.msg = msg;
		this.heading = heading;
		this.userName = userName;
		this.rating = rating;
		this.product = product;
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "Reviews [reviewCode=" + reviewCode + ", msg=" + msg + ", heading=" + heading + ", rating=" + rating
				+ ", product=" + ", approve=" + approve + "]";
	}

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

}
