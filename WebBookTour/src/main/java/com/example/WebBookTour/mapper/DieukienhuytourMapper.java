package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DieukienhuytourDto;
import com.example.WebBookTour.entity.Dieukienhuytour;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DieukienhuytourMapper {
    Dieukienhuytour toEntity(DieukienhuytourDto dieukienhuytourDto);

    DieukienhuytourDto toDto(Dieukienhuytour dieukienhuytour);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dieukienhuytour partialUpdate(DieukienhuytourDto dieukienhuytourDto, @MappingTarget Dieukienhuytour dieukienhuytour);
}