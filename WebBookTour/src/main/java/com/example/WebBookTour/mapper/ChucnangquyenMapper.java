package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChucnangquyenDto;
import com.example.WebBookTour.entity.Chucnangquyen;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChucnangquyenMapper {
    Chucnangquyen toEntity(ChucnangquyenDto chucnangquyenDto);

    ChucnangquyenDto toDto(Chucnangquyen chucnangquyen);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chucnangquyen partialUpdate(ChucnangquyenDto chucnangquyenDto, @MappingTarget Chucnangquyen chucnangquyen);
}