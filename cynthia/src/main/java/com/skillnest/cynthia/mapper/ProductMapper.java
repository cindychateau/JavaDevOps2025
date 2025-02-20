package com.skillnest.cynthia.mapper;

import com.skillnest.cynthia.dto.ProductDTO;
import com.skillnest.cynthia.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    //Método que recibe producto y regresa DTO
    public ProductDTO toDTO(Product product) {
        if(product == null) {
            return null;
        }

        String categoryName = product.getCategory() != null ? product.getCategory().getCategoryName() : null;

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                categoryName
        );

    }

}
