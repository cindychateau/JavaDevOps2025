package com.skillnest.cynthia.mapper;

import com.skillnest.cynthia.dto.OrderDTO;
import com.skillnest.cynthia.dto.ProductDTO;
import com.skillnest.cynthia.model.Order;
import com.skillnest.cynthia.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source="products", target="products")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(source="category.categoryName", target="categoryName")
    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> productsToProductDTOs(List<Product> products);

    List<OrderDTO> ordersToOrderDTOs(List<Order> orders);
    
    @InheritInverseConfiguration //Mappeo inverso
    Order orderDTOToOrder(OrderDTO orderDTO);

}
