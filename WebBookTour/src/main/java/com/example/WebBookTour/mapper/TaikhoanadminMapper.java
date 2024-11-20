package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.TaikhoanadminDto;
import com.example.WebBookTour.entity.Taikhoanadmin;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaikhoanadminMapper {
    Taikhoanadmin toEntity(TaikhoanadminDto taikhoanadminDto);

    TaikhoanadminDto toDto(Taikhoanadmin taikhoanadmin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Taikhoanadmin partialUpdate(TaikhoanadminDto taikhoanadminDto, @MappingTarget Taikhoanadmin taikhoanadmin);
}