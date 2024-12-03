package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "thongtinhanhkhach")
public class Thongtinhanhkhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDatCho", nullable = false)
    private Datchotour idDatCho;

    @NotNull
    @Column(name = "tenHanhKhach", nullable = false , length = 150)
    private String tenHanhKhach;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name="ngaySinh")
    private LocalDate ngaySinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhomTuoi")
    private Nhomtuoi nhomTuoi;

}