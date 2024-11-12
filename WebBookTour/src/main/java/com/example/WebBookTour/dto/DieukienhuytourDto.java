package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Dieukienhuytour}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class DieukienhuytourDto {
    private Integer id;
    private Integer thoiGianTu;
    private Integer thoiGianDen;
    private Integer phanTramChiPhi;
    private String ghiChu;
}