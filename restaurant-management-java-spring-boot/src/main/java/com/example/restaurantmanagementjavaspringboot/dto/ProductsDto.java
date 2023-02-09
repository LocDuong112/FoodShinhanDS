package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    private String categoryName;
    private float priceValue;
    private float discountDto;

    // TODO: Link to linh's app
}
