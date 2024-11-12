package com.example.WebBookTour.dto;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;


/**
 * DTO for {@link com.example.WebBookTour.entity.Diadiem}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Data
public class DiadiemDto {
    private Integer id;

    @NotBlank(message = "Tên trường không bỏ trống !")
    private String ten;

    private VungmienDto idVungMien;
}