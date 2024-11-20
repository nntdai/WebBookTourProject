package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.HoivienDto;
import com.example.WebBookTour.entity.Hoivien;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HoivienMapper {
    Hoivien toEntity(HoivienDto hoivienDto);

    HoivienDto toDto(Hoivien hoivien);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hoivien partialUpdate(HoivienDto hoivienDto, @MappingTarget Hoivien hoivien);
}