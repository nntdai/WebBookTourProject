package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.Tourdulich;
import org.mapstruct.*;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChitietlichtrinhMapper {

    @Mapping(target = "id.idTour", source = "idIdTour")  // Ánh xạ từ DTO sang Entity
    @Mapping(target = "id.ngayThu", source = "ngayThu")  // Ánh xạ từ DTO sang Entity
    Chitietlichtrinh toEntity(ChitietlichtrinhDto chitietlichtrinhDto);

    @Mapping(target = "idIdTour", source = "id.idTour")  // Ánh xạ từ Entity sang DTO
    @Mapping(target = "ngayThu", source = "id.ngayThu")  // Ánh xạ từ Entity sang DTO
    ChitietlichtrinhDto toDto(Chitietlichtrinh chitietlichtrinh);

    @AfterMapping
    default void linkTourDuLich(@MappingTarget Tourdulich tourdulich) {
        tourdulich.getChitietlichtrinhs().forEach(chiTiet -> chiTiet.setIdTour(tourdulich));
        }


    Set<Chitietlichtrinh> toEntityList(Set<ChitietlichtrinhDto> dtoList);

    Set<ChitietlichtrinhDto> toDtoList(Set<Chitietlichtrinh> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chitietlichtrinh partialUpdate(ChitietlichtrinhDto chitietlichtrinhDto, @MappingTarget Chitietlichtrinh chitietlichtrinh);
}