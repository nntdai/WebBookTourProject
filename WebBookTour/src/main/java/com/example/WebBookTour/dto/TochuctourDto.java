package com.example.WebBookTour.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * DTO for {@link com.example.WebBookTour.entity.Tochuctour}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TochuctourDto {
    private Integer id;
    private TourdulichDto idTourDuLich;
    private NhansuDto idHDV;
    private Instant ngayKH;
    private Instant ngayVe;
    private Integer soCho;
    private Integer soChoCon;
    private Boolean status = true;
}