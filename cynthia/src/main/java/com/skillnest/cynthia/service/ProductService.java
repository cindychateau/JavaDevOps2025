package com.skillnest.cynthia.service;

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

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
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
