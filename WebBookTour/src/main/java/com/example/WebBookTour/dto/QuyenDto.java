package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * DTO for {@link com.example.WebBookTour.entity.Quyen}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class QuyenDto {
    private Integer id;
    private String ten;
}