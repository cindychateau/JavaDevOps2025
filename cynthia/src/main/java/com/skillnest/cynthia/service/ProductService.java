package com.skillnest.cynthia.service;

import com.skillnest.cynthia.dto.ProductDTO;
import com.skillnest.cynthia.mapper.ProductMapper;
import com.skillnest.cynthia.model.Product;
import com.skillnest.cynthia.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductDTO saveProduct(Product product) {
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> productExists = productRepository.findById(id);
        if(productExists.isPresent()) {
            return productRepository.save(product);
        }

        return null;
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> productExists = productRepository.findById(id);
        if(productExists.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
    
}
