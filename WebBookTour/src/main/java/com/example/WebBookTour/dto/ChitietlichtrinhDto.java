package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO for {@link com.example.WebBookTour.entity.Chitietlichtrinh}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ChitietlichtrinhDto {
    private Integer idIdTour;
    private String tenChiTiet;
    private Integer ngayThu;
    private Boolean buaSang = false;
    private Boolean buaTrua = false;
    private Boolean buaChieu = false;
    private Boolean buaToi = false;
    private String hinhAnh;
    private String mota;
}