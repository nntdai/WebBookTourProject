package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Chucvu}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ChucvuDto {
    private Integer id;
    private String ten;
}