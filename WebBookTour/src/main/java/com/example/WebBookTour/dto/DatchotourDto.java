package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Datchotour}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class DatchotourDto {
    private Integer id;
    private BigDecimal tongTien;
    private Instant ngayDatCho;
    private Integer diemTLCong;
    private Integer diemTLDung;
    private TochuctourDto idToChucTour;
    private KhachhangDto sdtKhachHang;
    private KhuyenmaiDto idKhuyenMai;
    private Boolean status;
}