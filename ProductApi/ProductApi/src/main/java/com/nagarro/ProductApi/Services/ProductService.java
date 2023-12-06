package com.nagarro.ProductApi.Services;

import java.util.List;

import com.nagarro.ProductApi.Entities.Product;

public interface ProductService {
	
	public List<Product> allProducts();

	public Product addProduct(Product product);
	
	public Product getProductById(String ProductCode) ;
	
	 public Product updateProductReview(Product product);
	 
	 public long countProduct() ;
	 
	 public Product deleteProductById(String ProductCode);

}
