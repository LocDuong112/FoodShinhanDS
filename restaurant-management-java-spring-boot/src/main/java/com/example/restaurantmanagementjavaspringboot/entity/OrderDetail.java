package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orderdetail")
public class OrderDetail {

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)), @AttributeOverride(name ="productId",column = @Column(name="product_id", nullable = false))})
    private OrderDetailPK Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",updatable = false,insertable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", updatable = false,insertable = false)
    private Products products;
    private Long quantity;
    private float price;

}
