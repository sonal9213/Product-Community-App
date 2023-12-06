package com.nagarro.ProductApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ProductApi.Dao.ProductDao;
import com.nagarro.ProductApi.Entities.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public Product addProduct(Product product) {
		System.out.println(product);
		try {
			return productDao.save(product);
		}
		catch(Exception e) {
			System.out.println("error save unsuccessful");
			return new Product();
		}
	}
	
	public List<Product> allProducts(){
		try{
			return productDao.findAll();
		}
		catch(Exception e) {
			System.out.println(" error can not able to find product list");
			return null;
		}
	}

	public Product getProductById(String productCode) {
		
		try{
			return productDao.findByProductCode(productCode);
		}
		
		catch(Exception e) {
			System.out.println("error product found with particular id");
			return null;
		}

	}

	public Product updateProductReview(Product product) {
		try {
			return productDao.save(product);
		}
		catch(Exception e) {
			System.out.println(" error update unsuccessful");
			return null;
		}
		
	}
	
	public long countProduct() {
		try{
			return productDao.count();
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	@Transactional
	public Product deleteProductById(String ProductCode) {
		
		try{
			productDao.deleteByProductCode(ProductCode);
			return null;
		}
		catch(Exception e) {
			System.out.println("error Problem in Deletion");
			return null;
		}
		
		
	}

}
