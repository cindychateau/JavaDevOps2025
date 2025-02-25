package com.example.cliente.controller;

import com.example.cliente.dto.ClientResponseDTO;
import com.example.cliente.dto.OrderDTO;
import com.example.cliente.feign.OrderFeignClient;
import com.example.cliente.model.Client;
import com.example.cliente.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    
    private final ClientService clientService;
    private final OrderFeignClient feignClient;
    
    @PostMapping
    public ResponseEntity<ClientResponseDTO> saveClient(@RequestBody Client client) {
        ClientResponseDTO clientDTO = clientService.saveClient(client);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getOneClient(@PathVariable String id) {
        ClientResponseDTO clientDTO = clientService.getClient(id);

        ResponseEntity<List<OrderDTO>> ordersList = feignClient.getOrdersByClientId(id);
        clientDTO.setOrders(ordersList.getBody());

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

}
