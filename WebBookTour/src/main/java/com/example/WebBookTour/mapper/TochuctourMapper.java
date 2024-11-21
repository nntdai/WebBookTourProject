package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.entity.Tochuctour;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TochuctourMapper {
    Tochuctour toEntity(TochuctourDto tochuctourDto);

    TochuctourDto toDto(Tochuctour tochuctour);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tochuctour partialUpdate(TochuctourDto tochuctourDto, @MappingTarget Tochuctour tochuctour);
}