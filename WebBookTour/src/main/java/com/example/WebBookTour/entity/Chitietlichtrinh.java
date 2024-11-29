package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chitietlichtrinh")
public class Chitietlichtrinh {
    @EmbeddedId
    private ChitietlichtrinhId id;

    @MapsId("idTour")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTour", nullable = false)
    private Tourdulich idTour;

    @Size(max = 50)
    @NotNull
    @Column(name = "tenChiTiet", nullable = false, length = 50)
    private String tenChiTiet;

    @NotNull
    @Column(name = "buaSang", nullable = false)
    private Boolean buaSang = false;

    @NotNull
    @Column(name = "buaTrua", nullable = false)
    private Boolean buaTrua = false;

    @NotNull
    @Column(name = "buaChieu", nullable = false)
    private Boolean buaChieu = false;

    @NotNull
    @Column(name = "buaToi", nullable = false)
    private Boolean buaToi = false;

    @Size(max = 100)
    @Column(name = "hinhAnh", length = 100)
    private String hinhAnh;


    @Column(name = "mota",columnDefinition = "TEXT")
    private String mota;

}