package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.entity.Cart;
import com.example.restaurantmanagementjavaspringboot.entity.ProductCart;
import com.example.restaurantmanagementjavaspringboot.entity.ProductCartPK;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, ProductCartPK> {
    void deleteByCartAndProducts(Cart cart, Products products);
}
