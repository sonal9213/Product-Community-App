package com.nagarro.ProductApi.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductApi.Entities.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, String> {
     public Product findByProductCode(String productCode);
     
     public List<Product> findByProductNameContainingIgnoreCase(String productName);
     
     public List<Product> findByBrandContainingIgnoreCase(String brand);
     
     public void deleteByProductCode(String ProductCode);
}
