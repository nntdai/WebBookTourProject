package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.QuyenDto;
import com.example.WebBookTour.entity.Quyen;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuyenMapper {
    Quyen toEntity(QuyenDto quyenDto);

    QuyenDto toDto(Quyen quyen);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Quyen partialUpdate(QuyenDto quyenDto, @MappingTarget Quyen quyen);
}