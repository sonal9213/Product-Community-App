package com.nagarro.ProductApi.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Entities.Reviews;

import jakarta.persistence.EntityManager;

@Repository
public interface ReviewsDao extends JpaRepository<Reviews, Integer> {
	
	List<Reviews> findByProduct(Product productCode);
	
	Reviews findByReviewCode(int reviewCode);
	
//	 @Autowired
//	    private EntityManager entityManager;
//	    
//	   
//	    public static int countApprovedReviewsByProductCode(String productCode) {
//	        TypedQuery<Long> query = entityManager.createQuery(
//	                "SELECT COUNT(r) FROM Review r WHERE r.productCode = :productCode AND r.approvalStatus = 1", Long.class);
//	        query.setParameter("productCode", productCode);
//	        return query.getSingleResult().intValue();
//	    }
	
//	int countReviewsByProductCode(String productCode);

//	@Modifying
//	@Query("UPDATE Reviews r SET r.approved = true WHERE r.reviewCode = :reviewCode")
//	void approveReviews(@Param("productCode") int reviewCode);
}
