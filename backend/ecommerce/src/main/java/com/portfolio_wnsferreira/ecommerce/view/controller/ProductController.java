package com.portfolio_wnsferreira.ecommerce.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.portfolio_wnsferreira.ecommerce.view.model.ProductRequest;
import com.portfolio_wnsferreira.ecommerce.view.model.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio_wnsferreira.ecommerce.model.Product;
import com.portfolio_wnsferreira.ecommerce.service.ProductService;
import com.portfolio_wnsferreira.ecommerce.shared.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductDTO> products = productService.getAll();

        ModelMapper mapper = new ModelMapper();

        List<ProductResponse> response = products.stream()
                .map(productDTO -> mapper.map(productDTO, ProductResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> getById(@PathVariable Integer id){

        Optional<ProductDTO> dto = productService.getById(id);

        ProductResponse product = new ModelMapper().map(dto.get(), ProductResponse.class);

        return new ResponseEntity<>(Optional.of(product), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> add(@RequestBody ProductRequest productReq){

        ModelMapper mapper = new ModelMapper();

        ProductDTO productDto = mapper.map(productReq, ProductDTO.class);

        productDto = productService.add(productDto);

        return new ResponseEntity<>(mapper.map(productDto, ProductResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Integer id, @RequestBody ProductRequest productReq){

        ModelMapper mapper = new ModelMapper();
        ProductDTO productDto = mapper.map(productReq, ProductDTO.class);

        productDto = productService.update(id, productDto);

        return new ResponseEntity<>(
                mapper.map(productDto, ProductResponse.class),
                HttpStatus.OK);
    }
}
