package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface DiadiemMapper {
    Diadiem toEntity(DiadiemDto diadiemDto);

    DiadiemDto toDto(Diadiem diadiem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Diadiem partialUpdate(DiadiemDto diadiemDto, @MappingTarget Diadiem diadiem);
}