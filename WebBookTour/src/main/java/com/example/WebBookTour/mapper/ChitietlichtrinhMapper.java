package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChitietlichtrinhMapper {
    Chitietlichtrinh toEntity(ChitietlichtrinhDto chitietlichtrinhDto);

    ChitietlichtrinhDto toDto(Chitietlichtrinh chitietlichtrinh);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chitietlichtrinh partialUpdate(ChitietlichtrinhDto chitietlichtrinhDto, @MappingTarget Chitietlichtrinh chitietlichtrinh);
}