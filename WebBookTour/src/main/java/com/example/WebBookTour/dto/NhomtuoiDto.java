package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Nhomtuoi}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class NhomtuoiDto {
    private Integer id;
    private String ten;
    private Integer tuoiTu;
    private Integer tuoiDen;
    private Integer phanTram;
}