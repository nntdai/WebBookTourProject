package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Khachhang}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class KhachhangDto {
    private String soDienThoai;
    private String ten;
    private String email;
    private Integer diemTichLuy;
    private Boolean status = false;
}