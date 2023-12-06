package com.nagarro.ProductApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ProductApi.Dao.ReviewsDao;
import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Entities.Reviews;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewsDao reviewsDao;

	public Reviews addReview(Reviews review) {

		Reviews reviewed = reviewsDao.save(review);
//		System.out.println(reviewed.toString());
		return reviewed;

	}
	
	public List<Reviews> getAllReviews(){
		return reviewsDao.findAll();
	}

	public List<Reviews> getReviews(Product product) {
		return reviewsDao.findByProduct(product);

	}
	
	public Reviews getReviewByCode(int reviewCode){
		return reviewsDao.findByReviewCode(reviewCode);
	}
	
	public void deleteReview(int ReviewCode) {
		 reviewsDao.deleteById(ReviewCode);
	}
	
	public long countReviews() {
		try{
			long count=0;
			List<Reviews> reviews= reviewsDao.findAll();
			for(Reviews r:reviews) {
				if(r.isApprove()) {
					count++;
				}
				
			}
			return count;
		}
		catch(Exception e) {
			return -1;
		}
		
	}

}
