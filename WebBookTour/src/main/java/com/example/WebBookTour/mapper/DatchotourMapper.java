package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.entity.Datchotour;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DatchotourMapper {
    Datchotour toEntity(DatchotourDto datchotourDto);

    DatchotourDto toDto(Datchotour datchotour);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Datchotour partialUpdate(DatchotourDto datchotourDto, @MappingTarget Datchotour datchotour);
}