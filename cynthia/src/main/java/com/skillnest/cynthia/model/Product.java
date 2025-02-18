package com.skillnest.cynthia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Column(columnDefinition="TEXT") //Cambio el tipo de dato de la columna, name, length
    private String description;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @PrePersist //Antes de generar el registro ejecuta
    protected void generateDate() {
        this.createdAt = new Date();
    }

    //@PreUpdate

}
