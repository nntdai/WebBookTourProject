package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Vungmien;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiadiemMapper {

    Diadiem toEntity(DiadiemDto diadiemDto);

    @Mapping(target = "idVungMien", ignore = true)
        // Bỏ qua ánh xạ idVungMien để tránh vòng lặp
    DiadiemDto toDto(Diadiem diadiem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Diadiem partialUpdate(DiadiemDto diadiemDto, @MappingTarget Diadiem diadiem);

    // Sử dụng @AfterMapping để ánh xạ thêm dữ liệu nếu cần
    @AfterMapping
    default void linkVungmien(@MappingTarget DiadiemDto diadiemDto, Diadiem diadiem, VungmienMapper vungmienMapper) {
        Vungmien vungmien = diadiem.getIdVungMien();
        System.out.println(vungmien.getTen());
        if (vungmien != null) {
            // Gọi Mapper để ánh xạ từ Vungmien sang VungmienDto
            diadiemDto.setIdVungMien(vungmienMapper.toDto(vungmien));
        }
    }
}