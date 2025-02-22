package com.skillnest.cynthia.controller;

import com.skillnest.cynthia.dto.OrderDTO;
import com.skillnest.cynthia.exception.ValidationException;
import com.skillnest.cynthia.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO,
                                                BindingResult result) {
        if(result.hasErrors()) {
            String allErrorMessages = result.getFieldErrors().stream()
                    .map(error -> "Campo: " + error.getField() + " - Error: " + error.getDefaultMessage())
                    .collect(Collectors.joining("\n")); // Usando salto de línea como separador
            //Arrojamos excepción
            throw new ValidationException(400, allErrorMessages);
        }

        OrderDTO newOrder = orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<OrderDTO>> getOrdersFromClient(@PathVariable String clientId) {
        List<OrderDTO> orders = orderService.getOrderByClient(clientId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
