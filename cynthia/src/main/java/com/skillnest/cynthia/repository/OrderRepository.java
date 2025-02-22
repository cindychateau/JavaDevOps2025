package com.skillnest.cynthia.repository;

import com.skillnest.cynthia.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByClientId(String clientId);

}
