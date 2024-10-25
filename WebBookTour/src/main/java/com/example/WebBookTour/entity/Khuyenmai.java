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
@Table(name = "khuyenmai")
public class Khuyenmai {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "ten", nullable = false, length = 40)
    private String ten;

    @Column(name = "phanTram", nullable = false)
    private Integer phanTram;

    @Column(name = "soLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "soLuongCon", nullable = false)
    private Integer soLuongCon;

    @Column(name = "giaTriDonTu", nullable = false, precision = 15, scale = 3)
    private BigDecimal giaTriDonTu;

    @Column(name = "ngayBatDau", nullable = false)
    private Instant ngayBatDau;

    @Column(name = "ngayKetThuc", nullable = false)
    private Instant ngayKetThuc;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "idKhuyenMai")
    private Set<Datchotour> datchotours = new LinkedHashSet<>();

}