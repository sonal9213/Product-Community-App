package com.nagarro.ProductApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductApi.Entities.User;
import com.nagarro.ProductApi.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin()
	@PostMapping("/user/register")
	public User register(@RequestBody User user) {
		user.setAdmin(false);
		System.out.println("sonal");
		return userService.register(user);
		
	}
	
	@CrossOrigin()
	@PostMapping("/user/login")
	public User login(@RequestBody User user) {
		System.out.println(user);
		return userService.login(user);
		
	}

}
