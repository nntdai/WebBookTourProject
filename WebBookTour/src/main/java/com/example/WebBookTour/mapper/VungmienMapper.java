package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Vungmien;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface VungmienMapper {
    Vungmien toEntity(VungmienDto vungmienDto);

    VungmienDto toDto(Vungmien vungmien);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Vungmien partialUpdate(VungmienDto vungmienDto, @MappingTarget Vungmien vungmien);
}