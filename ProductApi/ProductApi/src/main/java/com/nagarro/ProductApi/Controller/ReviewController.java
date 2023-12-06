package com.nagarro.ProductApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Entities.Reviews;
import com.nagarro.ProductApi.Services.ProductService;
import com.nagarro.ProductApi.Services.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ProductService productService;
	@CrossOrigin()
	@PostMapping("/Review/{productCode}")
	public Product addReview(@PathVariable("productCode") String productCode,@RequestBody Reviews review) {
//		System.out.println(review);
		Product product=productService.getProductById(productCode);
		List<Reviews> reviews=product.getReviews();
		review.setProductCode(productCode);
		review.setProduct(product);
		reviews.add(review);
		
		product.setReviews(reviews);
		Reviews reviewed=reviewService.addReview(review);
		return productService.updateProductReview(product);
	}
	
	@GetMapping("/Review/{productCode}")
	public List<Reviews> getAllReview(@PathVariable("productCode") 	String productCode){
		Product product=productService.getProductById(productCode);
		return reviewService.getReviews(product);
		
	}
	@CrossOrigin()
	@GetMapping("/Reviews")
	public List<Reviews> getReviews(){
		
		return reviewService.getAllReviews();
		
	}
	@CrossOrigin()
	@PatchMapping("/Review/{reviewCode}/approve")
	public ResponseEntity<String> approveReview(@PathVariable("reviewCode")int reviewCode){
		Reviews review=reviewService.getReviewByCode(reviewCode);
		review.setApprove(true);
		reviewService.addReview(review);
		return  ResponseEntity.ok("Review approved");
		
	}
	
	@CrossOrigin()
	@DeleteMapping("/Review/{reviewCode}")
	public ResponseEntity<String> deleteReview(@PathVariable("reviewCode")int reviewCode){
		reviewService.deleteReview(reviewCode);
		return  ResponseEntity.ok("Review deleted");
		
	}
	@CrossOrigin
	@PostMapping("/Review/countReviews")
	public int CountReviewByProduct(@RequestBody Product product) {
		int count=0;
		List<Reviews> reviews=reviewService.getReviews(product);
		for(Reviews r:reviews) {
			if(r.isApprove()) {
				count++;
			}
		}
		return count;
		
	}
	@CrossOrigin
	@PostMapping("/Review/average")
	public float AverageReviews(@RequestBody Product product) {
		float average=0;
		int count=0;
		int ratingSum=0;
		List<Reviews> reviews=reviewService.getReviews(product);
		for(Reviews r:reviews) {
			if(r.isApprove()) {
				ratingSum+=r.getRating();
				count++;
			}
		}
		average=ratingSum/count;
		return average;
	}
}
