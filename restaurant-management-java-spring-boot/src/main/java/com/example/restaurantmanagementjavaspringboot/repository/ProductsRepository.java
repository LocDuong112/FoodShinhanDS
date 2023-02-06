package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT * FROM PRODUCTS WHERE Name LIKE %?1%", nativeQuery = true)
    List<Products> findProductsByName(String name);

    @Query(value = "SELECT * FROM PRODUCTS WHERE ID IN" +
            "(SELECT PRODUCT_ID FROM ORDERDETAIL ORDER BY QUANTITY DESC FETCH NEXT 10 ROWS ONLY)", nativeQuery = true)
    List<Products> findMostBuyProducts();

}
