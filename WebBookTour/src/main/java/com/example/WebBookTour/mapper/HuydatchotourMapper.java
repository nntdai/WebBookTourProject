package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.HuydatchotourDto;
import com.example.WebBookTour.entity.Huydatchotour;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HuydatchotourMapper {
    Huydatchotour toEntity(HuydatchotourDto huydatchotourDto);

    HuydatchotourDto toDto(Huydatchotour huydatchotour);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Huydatchotour partialUpdate(HuydatchotourDto huydatchotourDto, @MappingTarget Huydatchotour huydatchotour);
}