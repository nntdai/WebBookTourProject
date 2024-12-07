package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.TochuctourDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.entity.Vungmien;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TochuctourMapper {

    Tochuctour toEntity(TochuctourDto tochuctourDto);
    @Mapping(target="idTourDuLich",ignore=true)
    @Mapping(target = "formattedNgayKH", ignore = true)
    TochuctourDto toDto(Tochuctour tochuctour);
    @AfterMapping
    default void linkTourDuLich(@MappingTarget TochuctourDto tochuctourDto,Tochuctour tochuctour, TourdulichMapper tourdulichMapper) {
        Tourdulich tourdulich = tochuctour.getIdTourDuLich();
        if (tourdulich != null) {
            // Gọi Mapper để ánh xạ từ Vungmien sang VungmienDto
            tochuctourDto.setIdTourDuLich(tourdulichMapper.toDto(tourdulich));
        }
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tochuctour partialUpdate(TochuctourDto tochuctourDto, @MappingTarget Tochuctour tochuctour);
}