package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "huydatchotour")
public class Huydatchotour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDatCho", nullable = false)
    private Datchotour idDatCho;

    @Column(name = "ngayHuy", nullable = false)
    private Instant ngayHuy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDKHuy", nullable = false)
    private Dieukienhuytour idDKHuy;


    @Column(name = "ghiChu",columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "chiPhiHuyTour", precision = 15, scale = 3)
    private BigDecimal chiPhiHuyTour;

    @Column(name = "chiPhiHoan", precision = 15, scale = 3)
    private BigDecimal chiPhiHoan;

}