package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface TourdulichMapper {
    Tourdulich toEntity(TourdulichDto tourdulichDto);

    TourdulichDto toDto(Tourdulich tourdulich);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Tourdulich partialUpdate(TourdulichDto tourdulichDto, @MappingTarget Tourdulich tourdulich);
}