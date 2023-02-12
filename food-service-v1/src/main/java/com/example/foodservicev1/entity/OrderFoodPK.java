package com.example.foodservicev1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Embeddable
public class OrderFoodPK implements Serializable {
    @Column(name = "orderid", nullable = false)
    private String orderId;
    @Column(name ="foodid",nullable = false)
    private String foodId;

    public OrderFoodPK(String orderId, String foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public OrderFoodPK() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderFoodPK that = (OrderFoodPK) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(foodId, that.foodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, foodId);
    }
}
