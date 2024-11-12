package com.example.WebBookTour.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data //toString
@AllArgsConstructor
@NoArgsConstructor
public class tourdulichDTO {
    @JsonProperty("ten")
    private String ten;

    @JsonProperty("giaTour")
    private BigDecimal giaTien;

    @JsonProperty("thoiGian")
    private String thoiGian;

    @JsonProperty("phuongTienDiChuyen")
    private String phuongTienDiChuyen;

    @JsonProperty("diaDiemKH")
    private String diadiemkhoiHanh;

    @JsonProperty("diaDiemThamQuan")
    private String diaDiemThamQuan;

}
