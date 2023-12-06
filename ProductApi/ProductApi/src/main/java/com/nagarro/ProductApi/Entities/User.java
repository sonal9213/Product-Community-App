package com.nagarro.ProductApi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class User {
	
	@Id
	String email;
	String firstName;
	String LastName;
	String Password;

	
	
	
	public User(String email, String firstName, String lastName, String password, boolean admin) {
		super();
		this.email = email;
		this.firstName = firstName;
		LastName = lastName;
		Password = password;
		this.admin = admin;
	}
	
	boolean admin;
	
	
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

}
