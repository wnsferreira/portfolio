package com.portfolio_wnsferreira.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio_wnsferreira.ecommerce.model.Product;
import com.portfolio_wnsferreira.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(Integer id){
        return productRepository.getbyId(id);
    }
    
    public Product add(Product product) {
        return productRepository.add(product);
    }

    public void delete (Integer id) {
        productRepository.delete(id);
    }

    public Product update(Integer id, Product product) {
        
        product.setId(id);

        return productRepository.update(product);
    }
}
