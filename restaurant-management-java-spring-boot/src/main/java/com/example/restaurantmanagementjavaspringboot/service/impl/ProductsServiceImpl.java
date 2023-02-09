package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.ProductsMapper;
import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import com.example.restaurantmanagementjavaspringboot.repository.ProductsRepository;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public List<ProductsDto> loadProductsCustomer(String role, Long lastProductsId, Long fetchNum) {
        // check role
        boolean checkCustomer = checkRole(role, "CUSTOMER");
        if (!checkCustomer) {
            return null;
        }

        // return product list
        return loadProducts(lastProductsId, fetchNum);
    }

    private List<ProductsDto> loadProducts(Long lastProductsId, Long fetchNum) {
        Long currentOffset = Long.valueOf(0);
        // Fetch first row
        if (lastProductsId == -1) {
            lastProductsId = productsRepository.firstRowId();
            currentOffset = productsRepository.rowNumById(lastProductsId) - 1;
        } else {
            // +1 bc need the offset to point to next row, not current last product
            currentOffset = productsRepository.rowNumById(lastProductsId);
        }

        List<Products> fetchProducts = productsRepository.fetchProducts(currentOffset, fetchNum);

        List<ProductsDto> fetchProductsDto = new ArrayList<>();
        for (Products products: fetchProducts) {
            ProductsDto tmpProductsDto = new ProductsDto();
            tmpProductsDto = productsMapper.INSTANCE.entitytoDto(products);
            tmpProductsDto.setCategoryName(products.getCategories().getName());
            tmpProductsDto.setPriceValue(products.getPrice().getPrice());
            tmpProductsDto.setDiscountDto(products.getDiscount().getPrice());

            fetchProductsDto.add(tmpProductsDto);
        }

        if (fetchProductsDto.isEmpty()) {
            return new ArrayList<ProductsDto>();
        }

        return fetchProductsDto;
    }

    private boolean checkRole(String inputRole, String role) {
        return inputRole.equals(role);
    }
}
