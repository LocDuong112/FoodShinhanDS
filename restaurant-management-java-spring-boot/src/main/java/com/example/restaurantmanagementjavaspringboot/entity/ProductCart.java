package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductCart")
public class ProductCart {

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)), @AttributeOverride(name = "cartId", column = @Column(name = "cart_id", nullable = false))})
    private ProductCartPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", updatable = false, insertable = false)
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", updatable = false, insertable = false)

    private Cart cart;
    private Long quantity;
}
