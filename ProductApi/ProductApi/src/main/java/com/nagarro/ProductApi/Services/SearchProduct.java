package com.nagarro.ProductApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.ProductApi.Dao.ProductDao;
import com.nagarro.ProductApi.Entities.Product;
import java.util.*;

@Service
public class SearchProduct {

	@Autowired
	private ProductDao productDao;

	public List<Product> getProduct(String productCode, String productName, String brand) {
		
		

		List<Product> products = new ArrayList<>();
		if (productCode != null) {
			Product product = productDao.findByProductCode(productCode);
			if (product != null) {
				products.add(product);
			}
//			
//			return products;
		}

		HashSet<Product> set = new HashSet<>();
		if (productName != null) {
			List<Product> productByName = productDao.findByProductNameContainingIgnoreCase(productName);
			if (productByName.size() > 0) {
				set.addAll(productByName);
			}
//			return products;

		}
		if (brand != null) {
			List<Product> productByBrand = productDao.findByBrandContainingIgnoreCase(brand);
			if (productByBrand.size() > 0) {
				if(productName != null) {
					set.retainAll(productByBrand);
				}
				else {
					set.addAll(productByBrand);
				}
				
			}

		}
		if (set.size() > 0) {
			for (Product h : set) {
				products.add(h);
			}
		}
		return products;

	}

}
