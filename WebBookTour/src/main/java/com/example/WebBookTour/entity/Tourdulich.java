package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tourdulich")
public class Tourdulich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 150)
    private String ten;

    @Column(name = "giaTour", nullable = false, precision = 15, scale = 3)
    private BigDecimal giaTour;

    @Column(name = "thoiGian", nullable = false, length = 10)
    private String thoiGian;

    @Column(name = "phuongTienDiChuyen", length = 50)
    private String phuongTienDiChuyen;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "diaDiemKH", nullable = false)
    private Diadiem diaDiemKH;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "diaDiemThamQuan", nullable = false)
    private Diadiem diaDiemThamQuan;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "idTour")
    private Set<Chitietlichtrinh> chitietlichtrinhs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idDatCho")
    private Set<Thongtinhanhkhach> thongtinhanhkhaches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTourDuLich")
    private Set<Tochuctour> tochuctours = new LinkedHashSet<>();

}