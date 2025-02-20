package com.skillnest.cynthia.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private String id;
    private String clientId;

    /*
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="orders_has_products",
        joinColumns = @JoinColumn(name="order_id"),
        inverseJoinColumns = @JoinColumn(name="product_id")
    )
     */
    private List<Product> products;

}
