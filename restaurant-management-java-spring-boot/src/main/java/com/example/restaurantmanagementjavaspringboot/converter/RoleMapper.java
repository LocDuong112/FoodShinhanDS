package com.example.restaurantmanagementjavaspringboot.converter;

import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import com.example.restaurantmanagementjavaspringboot.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto entityToDto(Role role);

    Role dtoToEntity(RoleDto roleDto);
}
