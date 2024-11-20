package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.PhanquyenDto;
import com.example.WebBookTour.entity.Phanquyen;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PhanquyenMapper {
    Phanquyen toEntity(PhanquyenDto phanquyenDto);

    PhanquyenDto toDto(Phanquyen phanquyen);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Phanquyen partialUpdate(PhanquyenDto phanquyenDto, @MappingTarget Phanquyen phanquyen);
}