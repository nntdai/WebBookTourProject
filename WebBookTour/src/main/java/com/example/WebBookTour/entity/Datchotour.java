package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "datchotour")
public class Datchotour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tongTien", nullable = false, precision = 15, scale = 3)
    private BigDecimal tongTien;

    @Column(name = "ngayDatCho", nullable = false)
    private Instant ngayDatCho;

    @Column(name = "diemTLCong")
    private Integer diemTLCong;

    @Column(name = "diemTLDung")
    private Integer diemTLDung;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idToChucTour", nullable = false)
    private Tochuctour idToChucTour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sdtKhachHang", nullable = false)
    private Khachhang sdtKhachHang;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhuyenMai")
    private Khuyenmai idKhuyenMai;



    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "idDatCho")
    private Set<Huydatchotour> huydatchotours = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idDatCho",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Thongtinhanhkhach> thongtinhanhkhachs = new LinkedHashSet<>();

}