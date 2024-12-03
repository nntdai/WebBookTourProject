package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ThongtinhanhkhachDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.entity.Thongtinhanhkhach;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface ThongtinhanhkhachMapper {

    @AfterMapping
    default void linkDatChoTour(@MappingTarget Datchotour datchotour) {
        datchotour.getThongtinhanhkhachs().forEach(thongtin -> thongtin.setIdDatCho(datchotour));
    }

    Thongtinhanhkhach toEntity(ThongtinhanhkhachDto thongtinhanhkhachDto);

    ThongtinhanhkhachDto toDto(Thongtinhanhkhach thongtinhanhkhach);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Thongtinhanhkhach partialUpdate(ThongtinhanhkhachDto thongtinhanhkhachDto, @MappingTarget Thongtinhanhkhach thongtinhanhkhach);
}