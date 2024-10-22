package com.example.WebBookTour.model;

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

    @Column(name = "phuongTienDiChuyen", length = 50)
    private String phuongTienDiChuyen;

    @Column(name = "soCho", nullable = false)
    private Integer soCho;

    @Column(name = "soChoCon", nullable = false)
    private Integer soChoCon;

    @Column(name = "ngayKH", nullable = false)
    private Instant ngayKH;

    @Column(name = "ngayVe", nullable = false)
    private Instant ngayVe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idHDV", nullable = false)
    private Nhansu idHDV;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diaDiemKH", nullable = false)
    private Diadiem diaDiemKH;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diaDiemThamQuan", nullable = false)
    private Diadiem diaDiemThamQuan;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "idTour")
    private Set<Chitietlichtrinh> chitietlichtrinhs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTour")
    private Set<Datchotour> datchotours = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idDatCho")
    private Set<Thongtinhanhkhach> thongtinhanhkhaches = new LinkedHashSet<>();

}