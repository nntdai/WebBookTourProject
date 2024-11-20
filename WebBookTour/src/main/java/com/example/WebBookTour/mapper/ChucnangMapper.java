package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChucnangDto;
import com.example.WebBookTour.entity.Chucnang;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChucnangMapper {
    Chucnang toEntity(ChucnangDto chucnangDto);

    ChucnangDto toDto(Chucnang chucnang);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chucnang partialUpdate(ChucnangDto chucnangDto, @MappingTarget Chucnang chucnang);
}