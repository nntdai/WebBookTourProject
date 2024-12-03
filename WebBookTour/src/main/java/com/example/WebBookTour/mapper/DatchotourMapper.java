package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DatchotourDto;
import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface DatchotourMapper {
    Datchotour toEntity(DatchotourDto datchotourDto);
    @Mapping(target = "idToChucTour", ignore = true)
    @Mapping(target = "sdtKhachHang", ignore = true)
    @Mapping(target="thongtinhanhkhachs",ignore=true)
    DatchotourDto toDto(Datchotour datchotour);

    @AfterMapping
    default void linkToChucTour(@MappingTarget DatchotourDto datchotourDto, Datchotour datchotour, TochuctourMapper TochuctourMapper) {
        Tochuctour tochuctours = datchotour.getIdToChucTour();
        if (tochuctours != null) {
        datchotourDto.setIdToChucTour(TochuctourMapper.toDto(tochuctours));
        }
    }
    @AfterMapping
    default void linkThongtinkhachhang(@MappingTarget DatchotourDto datchotourDto, Datchotour datchotour,ThongtinhanhkhachMapper thongtinhanhkhachMapper)
    {
        Set<Thongtinhanhkhach> datchotourSet = datchotour.getThongtinhanhkhachs();
        if (datchotourSet != null) {
            datchotourDto.setThongtinhanhkhachs(datchotourSet.stream().map(thongtinhanhkhachMapper :: toDto).collect(Collectors.toSet()));
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