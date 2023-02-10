package com.example.restaurantmanagementjavaspringboot.dto;

import com.example.restaurantmanagementjavaspringboot.entity.ProductCartPK;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartDto {
    private ProductCartPK id;
    private Long cartId;
    private Long productId;
    private Long quantity;
}
