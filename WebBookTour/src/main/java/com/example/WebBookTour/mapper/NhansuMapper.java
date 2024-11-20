package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.entity.Nhansu;
import com.example.WebBookTour.entity.Taikhoanadmin;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NhansuMapper {
    Nhansu toEntity(NhansuDto nhansuDto);

    @AfterMapping
    default void linkTaikhoanadmin(@MappingTarget Nhansu nhansu) {
        Taikhoanadmin taikhoanadmin = nhansu.getTaikhoanadmin();
        if (taikhoanadmin != null) {
            taikhoanadmin.setIdNhanVien(nhansu);
        }
    }

    NhansuDto toDto(Nhansu nhansu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Nhansu partialUpdate(NhansuDto nhansuDto, @MappingTarget Nhansu nhansu);
}