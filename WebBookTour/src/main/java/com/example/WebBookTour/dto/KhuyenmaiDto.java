package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Khuyenmai}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class KhuyenmaiDto {
    private String id;
    private String ten;
    private Integer phanTram;
    private Integer soLuong;
    private Integer soLuongCon;
    private BigDecimal giaTriDonTu;
    private Instant ngayBatDau;
    private Instant ngayKetThuc;
    private Boolean status;
}