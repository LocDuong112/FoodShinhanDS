package com.example.restaurantmanagementjavaspringboot.converter;

import com.example.restaurantmanagementjavaspringboot.dto.BillDto;
import com.example.restaurantmanagementjavaspringboot.entity.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BillMapper {
    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);
    BillDto entityToDto(Bill bill);
    Bill dtoToEntity(BillDto billDto);
}
