package com.skillnest.cynthia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String descripcionLarga;
    private int stock;

    @JsonBackReference
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id") //Foreign Key Llave foránea
    private Product product;

}
