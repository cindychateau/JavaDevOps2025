package com.example.cliente.service;

import com.example.cliente.dto.ClientResponseDTO;
import com.example.cliente.mapper.ClientMapper;
import com.example.cliente.model.Client;
import com.example.cliente.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponseDTO saveClient(Client client) {
        clientRepository.save(client);
        return clientMapper.clientToClientDTO(client);
    }

    public ClientResponseDTO getClient(String id) {
        Client client = clientRepository.findById(id).orElse(null);
        return clientMapper.clientToClientDTO(client);
    }

}
