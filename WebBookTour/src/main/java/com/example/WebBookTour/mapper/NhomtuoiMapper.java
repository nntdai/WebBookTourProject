package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.NhomtuoiDto;
import com.example.WebBookTour.entity.Nhomtuoi;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NhomtuoiMapper {
    Nhomtuoi toEntity(NhomtuoiDto nhomtuoiDto);

    NhomtuoiDto toDto(Nhomtuoi nhomtuoi);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Nhomtuoi partialUpdate(NhomtuoiDto nhomtuoiDto, @MappingTarget Nhomtuoi nhomtuoi);
}