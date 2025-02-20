package com.skillnest.cynthia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    
    @JsonManagedReference
    @OneToOne(mappedBy="product",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private ProductDetail detail;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    /*
    @JsonIgnore //Para ignorarlo por completo
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="orders_has_products",
        joinColumns = @JoinColumn(name="product_id"),
        inverseJoinColumns = @JoinColumn(name="order_id")
   )
    private List<Order> orders;
     */

    @PrePersist //Antes de generar el registro ejecuta
    protected void generateDate() {
        this.createdAt = new Date();
    }

    //@PreUpdate

}
