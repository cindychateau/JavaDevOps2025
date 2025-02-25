package com.example.cliente.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private String id;
    private String name;

}
