package com.portfolio_wnsferreira.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.portfolio_wnsferreira.ecommerce.model.Product;
import com.portfolio_wnsferreira.ecommerce.model.exception.ResourceNotFoundException;

@Repository
public class ProductRepository {
    
    private List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    public List<Product> getAll(){
        return products;
    }

    public Optional<Product> getbyId(Integer id){
        return products
            .stream()
            .filter(product -> product.getId() == id)
            .findFirst();
    }
    
    public Product add(Product product){
        lastId++;

        product.setId(lastId);
        products.add(product);

        return product;
    }

    public void delete (Integer id){
        products.removeIf(product -> product.getId() == id);
    }

    public Product update(Product product){
        Optional<Product> productFound = getbyId(product.getId());

        if(productFound.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        delete(product.getId());

        products.add(product);

        return product;
    }
}
