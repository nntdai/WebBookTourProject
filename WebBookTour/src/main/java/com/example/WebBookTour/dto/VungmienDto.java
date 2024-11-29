package com.example.WebBookTour.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.example.WebBookTour.entity.Vungmien}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class VungmienDto {
    private Integer id;
    private String ten;
    private Set<DiadiemDto> diadiems = new LinkedHashSet<>();;
}