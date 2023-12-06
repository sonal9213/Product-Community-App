package com.nagarro.ProductApi.Services;

import com.nagarro.ProductApi.Entities.User;

public interface UserService {
	
	public User register(User user) ;
	public long countUser();
	public User login(User user);
}
