package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Taikhoanadmin}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TaikhoanadminDto {
    private Integer id;
    private String username;
    private String password;
    private Instant ngayCap;
    private Boolean status;
    private ChucvuDto idChucVu;
}