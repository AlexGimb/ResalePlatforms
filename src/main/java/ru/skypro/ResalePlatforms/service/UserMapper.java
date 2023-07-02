package ru.skypro.ResalePlatforms.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.ResalePlatforms.dto.UserDTO;
import ru.skypro.ResalePlatforms.entity.UserClient;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    UserDTO toDto(UserClient userClient);

    UserClient toEntity(UserDTO userDTO);
}
