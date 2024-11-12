package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Huydatchotour}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class HuydatchotourDto {
    private Integer id;
    private DatchotourDto idDatCho;
    private Instant ngayHuy;
    private DieukienhuytourDto idDKHuy;
    private String ghiChu;
    private BigDecimal chiPhiHuyTour;
    private BigDecimal chiPhiHoan;
}