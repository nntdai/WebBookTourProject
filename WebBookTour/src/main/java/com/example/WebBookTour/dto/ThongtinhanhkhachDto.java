package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Thongtinhanhkhach}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ThongtinhanhkhachDto {
    private Integer idIdDatCho;
    private Integer idTenHanhKhach;
    private TourdulichDto idDatCho;
    private Boolean gioiTinh;
    private NhomtuoiDto nhomTuoi;
}