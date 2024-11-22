package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TourdulichMapper {
    Tourdulich toEntity(TourdulichDto tourdulichDto);

    @AfterMapping
    default void linkChitietlichtrinhs(@MappingTarget Tourdulich tourdulich) {
        tourdulich.getChitietlichtrinhs().forEach(chitietlichtrinh -> chitietlichtrinh.setIdTour(tourdulich));
    }

    @AfterMapping
    default void linkThongtinhanhkhaches(@MappingTarget Tourdulich tourdulich) {
        tourdulich.getThongtinhanhkhaches().forEach(thongtinhanhkhach -> thongtinhanhkhach.setIdDatCho(tourdulich));
    }

    @AfterMapping
    default void linkTochuctours(@MappingTarget Tourdulich tourdulich) {
        tourdulich.getTochuctours().forEach(tochuctour -> tochuctour.setIdTourDuLich(tourdulich));
    }

    TourdulichDto toDto(Tourdulich tourdulich);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tourdulich partialUpdate(TourdulichDto tourdulichDto, @MappingTarget Tourdulich tourdulich);
}