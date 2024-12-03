package com.example.WebBookTour.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.WebBookTour.entity.Thongtinhanhkhach}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ThongtinhanhkhachDto {
    private Integer id;
    @NotNull
    private DatchotourDto idDatCho;
    @NotNull
    private String tenHanhKhach;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private NhomtuoiDto nhomTuoi;
}