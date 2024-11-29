package com.example.WebBookTour.mapper;

import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.entity.Diadiem;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VungmienMapper {

    Vungmien toEntity(VungmienDto vungmienDto);

    @Mapping(target = "diadiems", ignore = true)  // Bỏ qua ánh xạ diadiems để tránh vòng lặp
    VungmienDto toDto(Vungmien vungmien);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Vungmien partialUpdate(VungmienDto vungmienDto, @MappingTarget Vungmien vungmien);

    // Sử dụng @AfterMapping để ánh xạ thêm dữ liệu nếu cần
    @AfterMapping
    default void linkDiadiems(@MappingTarget VungmienDto vungmienDto, Vungmien vungmien, DiadiemMapper diadiemMapper) {
        Set<Diadiem> diadiems = vungmien.getDiadiems();
        if (diadiems != null) {
            // Gọi DiadiemMapper để ánh xạ từng Diadiem thành DiadiemDto
            vungmienDto.setDiadiems(
                    diadiems.stream()
                            .map(diadiemMapper::toDto) // Sử dụng mapper để ánh xạ
                            .collect(Collectors.toSet())
            );
        }
    }
}