package com.skillnest.cynthia.service;

import com.skillnest.cynthia.dto.OrderDTO;
import com.skillnest.cynthia.mapper.OrderMapper;
import com.skillnest.cynthia.model.Order;
import com.skillnest.cynthia.model.Product;
import com.skillnest.cynthia.repository.OrderRepository;
import com.skillnest.cynthia.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();

//        return orders
//                .stream()
//                .map(order -> orderMapper.orderToOrderDTO(order))
//                .collect(Collectors.toList());

        return orderMapper.ordersToOrderDTOs(orders);

    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        List<Product> products = orderDTO.getProducts().stream()
                                .map(dto -> {
                                    Product prd =productRepository.findById(dto.getId()).orElse(null);
                                    prd.setCategory(null);
                                    prd.setDetail(null);
                                    return prd;
                                })
                                .collect(Collectors.toList());
        System.out.println(orderDTO.getClientId());
        Order order = orderMapper.orderDTOToOrder(orderDTO);
        System.out.println(order.getClientId());
        order.setProducts(products);
        orderRepository.save(order);
        return orderMapper.orderToOrderDTO(order);
    }

    public OrderDTO getOrder(String id) {
        Order order = orderRepository.findById(id).orElse(null);

        List<Product> products = order.getProducts().stream()
                                .map(prod -> productRepository.findById(prod.getId()).orElse(null))
                                .collect(Collectors.toList());
        order.setProducts(products);
        return orderMapper.orderToOrderDTO(order);

    }

    public List<OrderDTO> getOrderByClient(String clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        return orderMapper.ordersToOrderDTOs(orders);
    }

}
