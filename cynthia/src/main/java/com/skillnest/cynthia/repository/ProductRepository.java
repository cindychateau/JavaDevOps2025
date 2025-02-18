package com.skillnest.cynthia.repository;

import com.skillnest.cynthia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
    CrudRepository: findAll(), findById(), save(), deleteById(), count()
    JpaRepository: CrudRepo, Paging+Sort,
    * */

    Product findByName(String name);

    //SELECT * FROM products WHERE description LIKE "%<word>%"
    List<Product> findByDescriptionContaining(String word);

}
