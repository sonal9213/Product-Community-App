package com.nagarro.ProductApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductApi.Entities.stats;
import com.nagarro.ProductApi.Services.ProductService;
import com.nagarro.ProductApi.Services.ReviewService;
import com.nagarro.ProductApi.Services.UserService;

@RestController
public class statsController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;
	
	@CrossOrigin()	
	@GetMapping("/count")
	public stats count() {
		stats st=new stats();
		long productcount=productService.countProduct();
		long usercount=userService.countUser();
		long reviewcount=reviewService.countReviews();
		st.setCountProducts(productcount);
		st.setCountReviews(reviewcount);
		st.setCountUsers( usercount);
		return st;
		
		
	}


}
