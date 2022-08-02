package com.portfolio_wnsferreira.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.portfolio_wnsferreira.ecommerce.model.Product;
import com.portfolio_wnsferreira.ecommerce.model.exception.ResourceNotFoundException;
import com.portfolio_wnsferreira.ecommerce.repository.ProductRepositoryDb;
import com.portfolio_wnsferreira.ecommerce.shared.ProductDTO;


@Service
public class ProductService {

    @Autowired
    private ProductRepositoryDb productRepository;

    public List<ProductDTO> getAll() {

        List<Product> products = productRepository.findAll();

        return products.stream()
        .map(product -> new ModelMapper().map(product, ProductDTO.class))
        .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getById(Integer id){

//          Obtendo optional de produto por id.
            Optional<Product> product = productRepository.findById(id);

//          Se não encontrar, lança exception.
            if(product.isEmpty()){
                throw new ResourceNotFoundException("Produto com id: " + id + " não encontrado.");
            }

//          converte optional de product em produtoDTO.
            ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);

//          Cria e retorna um optional de dto.
            return Optional.of(dto);
    }
    
    public ProductDTO add(ProductDTO productDto) {

//      Remover o id para conseguir fazer o cadastro.
        productDto.setId(null);

//      criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

//      converter ProductDTO em um Product.
        Product product = mapper.map(productDto, Product.class);

//      Salvar o Produto no banco.
        product = productRepository.save(product);
        productDto.setId(product.getId());

//      Retornar o ProdutoDTO atualizado.
        return productDto;
    }

    public void delete (Integer id) {
//        Verificar se o produto existe
        Optional<Product> product = productRepository.findById(id);

//        Se não existir lança uma exception
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar o produto com id: " + id + " -Produto não existe.");
        }

//        Deleta pelo id
        productRepository.deleteById(id);
    }

    public ProductDTO update(Integer id, ProductDTO productDto) {

//        Passar o id para o produtoDTO
        productDto.setId(id);

//        Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

//        converter o ProdutoDTO em um Produto
        Product product = mapper.map(productDto, Product.class);

//        Atualizar o Produto no banco.
        productRepository.save(product);

//        Retornar o produtoDto atualizado
        return productDto;
    }
}
