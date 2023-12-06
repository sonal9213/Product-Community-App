package com.nagarro.ProductApi.Services;

import java.util.List;

import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Entities.Reviews;

public interface ReviewService {
	
	public Reviews addReview(Reviews review);
	public List<Reviews> getReviews(Product product);
	public Reviews getReviewByCode(int reviewCode);
	public List<Reviews> getAllReviews();
	public void deleteReview(int ReviewCode);
	public long countReviews();

}
