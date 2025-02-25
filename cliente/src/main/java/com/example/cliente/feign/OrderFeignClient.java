package com.example.cliente.feign;

import com.example.cliente.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="OrderFeign", url="http://localhost:8080")
public interface OrderFeignClient {
    
    @GetMapping("/api/orders/client/{id}")
    public ResponseEntity<List<OrderDTO>> getOrdersByClientId(@PathVariable String id);
    
}
