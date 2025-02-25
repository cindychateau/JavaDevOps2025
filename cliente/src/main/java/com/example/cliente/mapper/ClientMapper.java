package com.example.cliente.mapper;

import com.example.cliente.dto.ClientResponseDTO;
import com.example.cliente.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ClientMapper {

    ClientResponseDTO clientToClientDTO(Client client);

}
