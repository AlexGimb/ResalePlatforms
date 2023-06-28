package ru.skypro.ResalePlatforms.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.ResalePlatforms.dto.AdDTO;
import ru.skypro.ResalePlatforms.entity.Ad;

@Mapper
public interface AdMapper {
    AdMapper INSTANCE = Mappers.getMapper(AdMapper.class);

    AdDTO toDto(Ad ad);

    Ad toEntity(AdDTO adDTO);
}
