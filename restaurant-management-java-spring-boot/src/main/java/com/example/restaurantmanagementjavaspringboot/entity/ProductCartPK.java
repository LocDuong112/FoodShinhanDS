package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProductCartPK implements Serializable {
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCartPK that = (ProductCartPK) o;
        return Objects.equals(productId, that.productId) && Objects.equals(cartId, that.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cartId);
    }

    @Override
    public String toString() {
        return "ProductCartPK{" +
                "productId=" + productId +
                ", cartId=" + cartId +
                '}';
    }
}
