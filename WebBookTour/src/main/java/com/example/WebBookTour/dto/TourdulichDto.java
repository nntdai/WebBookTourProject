package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.WebBookTour.entity.Tourdulich}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TourdulichDto {
    private Integer id;
    private String ten;
    private BigDecimal giaTour;
    private String thoiGian;
    private String phuongTienDiChuyen;
    private DiadiemDto diaDiemKH;
    private DiadiemDto diaDiemThamQuan;
    private Boolean status;
}