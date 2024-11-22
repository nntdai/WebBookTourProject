package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.ChitietlichtrinhId;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChitietlichtrinhMapper {

    @Mapping(target = "id.idTour", source = "idIdTour")  // Ánh xạ từ DTO sang Entity
    @Mapping(target = "id.tenChiTiet", source = "idTenChiTiet")  // Ánh xạ từ DTO sang Entity
    Chitietlichtrinh toEntity(ChitietlichtrinhDto chitietlichtrinhDto);

    @Mapping(target = "idIdTour", source = "id.idTour")  // Ánh xạ từ Entity sang DTO
    @Mapping(target = "idTenChiTiet", source = "id.tenChiTiet")  // Ánh xạ từ Entity sang DTO
    ChitietlichtrinhDto toDto(Chitietlichtrinh chitietlichtrinh);

    List<Chitietlichtrinh> toEntityList(List<ChitietlichtrinhDto> dtoList);

    List<ChitietlichtrinhDto> toDtoList(List<Chitietlichtrinh> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chitietlichtrinh partialUpdate(ChitietlichtrinhDto chitietlichtrinhDto, @MappingTarget Chitietlichtrinh chitietlichtrinh);
}