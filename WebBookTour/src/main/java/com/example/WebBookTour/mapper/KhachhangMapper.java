package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.KhachhangDto;
import com.example.WebBookTour.entity.Khachhang;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KhachhangMapper {
    Khachhang toEntity(KhachhangDto khachhangDto);

    KhachhangDto toDto(Khachhang khachhang);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Khachhang partialUpdate(KhachhangDto khachhangDto, @MappingTarget Khachhang khachhang);
}