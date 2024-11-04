package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tochuctour")
public class Tochuctour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTourDuLich", nullable = false)
    private Tourdulich idTourDuLich;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idHDV", nullable = false)
    private Nhansu idHDV;

    @Column(name = "ngayKH", nullable = false)
    private Instant ngayKH;

    @Column(name = "ngayVe", nullable = false)
    private Instant ngayVe;

    @Column(name = "soCho", nullable = false)
    private Integer soCho;

    @Column(name = "soChoCon", nullable = false)
    private Integer soChoCon;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @OneToMany(mappedBy = "idToChucTour")
    private Set<Datchotour> datchotours = new LinkedHashSet<>();

}