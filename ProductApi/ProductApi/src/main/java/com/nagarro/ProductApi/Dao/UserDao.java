package com.nagarro.ProductApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Entities.User;


@Repository
public interface UserDao extends JpaRepository<User, String> {
	 public User findByEmail(String email);

}
