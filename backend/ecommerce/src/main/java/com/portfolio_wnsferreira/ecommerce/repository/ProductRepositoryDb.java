package com.portfolio_wnsferreira.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.portfolio_wnsferreira.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepositoryDb extends JpaRepository<Product, Integer>{
    
}
