package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProductCartPK implements Serializable {
    private Long productsId;
    private Long cartId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCartPK that = (ProductCartPK) o;
        return Objects.equals(productsId, that.productsId) && Objects.equals(cartId, that.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productsId, cartId);
    }

    @Override
    public String toString() {
        return "ProductCartPK{" + "productId=" + productsId + ", cartId=" + cartId + '}';
    }
}
