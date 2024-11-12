package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Chucnangquyen}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ChucnangquyenDto {
    private Integer id;
    private ChucnangDto idChucNang;
    private QuyenDto idQuyen;
}