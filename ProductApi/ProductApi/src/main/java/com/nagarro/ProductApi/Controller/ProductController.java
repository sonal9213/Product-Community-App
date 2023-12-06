package com.nagarro.ProductApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductApi.Entities.Product;
import com.nagarro.ProductApi.Services.ProductService;
import com.nagarro.ProductApi.Services.SearchProduct;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SearchProduct searchProduct;
	
	@CrossOrigin()
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
		
	}
	@CrossOrigin()
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.allProducts();
	}
	
	@CrossOrigin()
	@GetMapping("/product/{productCode}")
	public Product getProductByCode(@PathVariable("productCode") String productCode) {
		return productService.getProductById(productCode);
		
	}
	@CrossOrigin()
	@GetMapping("/product/search")
	public List<Product> getProductBySearch(@RequestParam(value = "productCode", required = false) String productCode,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "brand", required = false) String brand){
		System.out.println("coming"+brand);
		return searchProduct.getProduct(productCode, productName, brand);
		
	}
	@CrossOrigin()
	@DeleteMapping("/products/delete/{productCode}")
	public Product deleteProduct(@PathVariable String productCode) {
		return productService.deleteProductById(productCode);
		
	}
}
