package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.Tochuctour;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ChitietlichtrinhMapper.class,VungmienMapper.class,DiadiemMapper.class})
public interface TourdulichMapper {

    Tourdulich toEntity(TourdulichDto tourdulichDto);

    @AfterMapping
    default void linkChitietlichtrinhs(@MappingTarget TourdulichDto tourdulichDto,Tourdulich tourdulich,ChitietlichtrinhMapper ChitietlichtrinhMapper) {
        Set<Chitietlichtrinh> chitietlichtrinhs = tourdulich.getChitietlichtrinhs();
        if (chitietlichtrinhs != null) {
            tourdulichDto.setChitietlichtrinhs(chitietlichtrinhs.stream().map(ChitietlichtrinhMapper::toDto).collect(Collectors.toSet()));
        }

    }

//    @AfterMapping
//    default void linkThongtinhanhkhaches(@MappingTarget Tourdulich tourdulich) {
//        tourdulich.getThongtinhanhkhaches().forEach(thongtinhanhkhach -> thongtinhanhkhach.setIdDatCho(tourdulich));
//    }

    @AfterMapping
        default void linkTochuctours(@MappingTarget TourdulichDto tourdulichDto,Tourdulich tourdulich,TochuctourMapper TochuctourMapper) {
        Set<Tochuctour> tochuctours = tourdulich.getTochuctours();
        if (tochuctours != null) {
            tourdulichDto.setTochuctours(tochuctours.stream().map(TochuctourMapper::toDto).collect(Collectors.toSet()));
        }
    }
    @Mapping(target = "tochuctours", ignore = true)
    @Mapping(target = "chitietlichtrinhs", ignore = true)
    TourdulichDto toDto(Tourdulich tourdulich);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tourdulich partialUpdate(TourdulichDto tourdulichDto, @MappingTarget Tourdulich tourdulich);
}