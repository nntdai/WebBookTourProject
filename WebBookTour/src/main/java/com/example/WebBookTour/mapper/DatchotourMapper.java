package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Datchotour;
import com.example.WebBookTour.entity.Khachhang;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;



@Mapper(componentModel = "spring")
public interface DatchotourMapper {
    Datchotour toEntity(DatchotourDto datchotourDto);
    @Mapping(target = "idToChucTour", ignore = true)
    @Mapping(target = "sdtKhachHang", ignore = true)
    DatchotourDto toDto(Datchotour datchotour);

    @AfterMapping
    default void linkToChucTour(@MappingTarget DatchotourDto datchotourDto, Datchotour datchotour, TochuctourMapper TochuctourMapper) {
        Tochuctour tochuctours = datchotour.getIdToChucTour();
        if (tochuctours != null) {
        datchotourDto.setIdToChucTour(TochuctourMapper.toDto(tochuctours));
        }
    }
    @AfterMapping
    default void linkKhachHang(@MappingTarget DatchotourDto datchotourDto, Datchotour datchotour, KhachhangMapper khachhangMapper) {
        Khachhang khachhang = datchotour.getSdtKhachHang();
        if (khachhang != null) {
            datchotourDto.setSdtKhachHang(khachhangMapper.toDto(khachhang));
        }
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Datchotour partialUpdate(DatchotourDto datchotourDto, @MappingTarget Datchotour datchotour);
}