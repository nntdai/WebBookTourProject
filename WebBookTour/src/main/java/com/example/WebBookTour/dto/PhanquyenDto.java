package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Phanquyen}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PhanquyenDto {
    private Integer idIdChucVu;
    private Integer idIdChucNangQuyen;
    private ChucvuDto idChucVu;
    private ChucnangquyenDto idChucNangQuyen;
    private Boolean status;
}