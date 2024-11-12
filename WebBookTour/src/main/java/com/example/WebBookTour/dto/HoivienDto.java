package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Hoivien}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class HoivienDto {
    private Integer id;
    private String password;
    private KhachhangDto idKhachHang;
    private Instant ngaySinh;
    private String cmnd;
    private String diaChi;
    private Instant ngayTao;
    private Boolean status = false;
}