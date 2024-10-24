package com.example.WebBookTour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dieukienhuytour")
public class Dieukienhuytour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "thoiGianTu")
    private Integer thoiGianTu;

    @Column(name = "thoiGianDen")
    private Integer thoiGianDen;

    @Column(name = "phanTramChiPhi")
    private Integer phanTramChiPhi;

    @Lob
    @Column(name = "ghiChu")
    private String ghiChu;

    @OneToMany(mappedBy = "idDKHuy")
    private Set<Huydatchotour> huydatchotours = new LinkedHashSet<>();

}