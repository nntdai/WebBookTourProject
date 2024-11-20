package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ThongtinhanhkhachDto;
import com.example.WebBookTour.entity.Thongtinhanhkhach;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ThongtinhanhkhachMapper {
    Thongtinhanhkhach toEntity(ThongtinhanhkhachDto thongtinhanhkhachDto);

    ThongtinhanhkhachDto toDto(Thongtinhanhkhach thongtinhanhkhach);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Thongtinhanhkhach partialUpdate(ThongtinhanhkhachDto thongtinhanhkhachDto, @MappingTarget Thongtinhanhkhach thongtinhanhkhach);
}