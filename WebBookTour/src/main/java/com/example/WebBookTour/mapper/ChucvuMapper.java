package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChucvuDto;
import com.example.WebBookTour.entity.Chucvu;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChucvuMapper {
    Chucvu toEntity(ChucvuDto chucvuDto);

    ChucvuDto toDto(Chucvu chucvu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chucvu partialUpdate(ChucvuDto chucvuDto, @MappingTarget Chucvu chucvu);
}