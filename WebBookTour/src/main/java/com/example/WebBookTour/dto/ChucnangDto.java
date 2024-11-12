package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Chucnang}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ChucnangDto {
    private Integer id;
    private String ten;
}