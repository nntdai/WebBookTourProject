package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Nhansu}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class NhansuDto {
    private Integer id;
    private String ten;
    private String diaChi;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String hinhAnh;
    private Boolean status;
    private TaikhoanadminDto taikhoanadmin;
}