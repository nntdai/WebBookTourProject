package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.KhuyenmaiDto;
import com.example.WebBookTour.entity.Khuyenmai;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KhuyenmaiMapper {
    Khuyenmai toEntity(KhuyenmaiDto khuyenmaiDto);

    KhuyenmaiDto toDto(Khuyenmai khuyenmai);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Khuyenmai partialUpdate(KhuyenmaiDto khuyenmaiDto, @MappingTarget Khuyenmai khuyenmai);
}