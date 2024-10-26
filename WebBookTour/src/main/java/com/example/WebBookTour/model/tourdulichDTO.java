package com.example.WebBookTour.model;

import lombok.*;

import java.math.BigDecimal;

@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class tourdulichDTO {
    private String ten;
    private String khoiHanh;
    private String NgayKhoiHang;
    private String thoiGian;
    private Long soChoConLai;
    private BigDecimal giaTien;
    private String hinhAnh;
}
