package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private String formattedNgayDatCho;
    private Integer diemTLCong;
    private Integer diemTLDung;
    private TochuctourDto idToChucTour;
    private KhachhangDto sdtKhachHang;
    private String email;
    private KhuyenmaiDto idKhuyenMai;
    private Boolean status;
    private Set<ThongtinhanhkhachDto> thongtinhanhkhachs = new LinkedHashSet<>();


}