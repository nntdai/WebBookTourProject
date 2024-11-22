package com.example.WebBookTour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idTour", nullable = false)
    @JsonBackReference
    private Tourdulich idTour;

    @Column(name = "ngayThu", nullable = false)
    private Integer ngayThu;

    @Column(name = "buaSang", nullable = false)
    private Boolean buaSang = false;

    @Column(name = "buaTrua", nullable = false)
    private Boolean buaTrua = false;

    @Column(name = "buaChieu", nullable = false)
    private Boolean buaChieu = false;

    @Column(name = "buaToi", nullable = false)
    private Boolean buaToi = false;

    @Column(name = "hinhAnh", length = 100)
    private String hinhAnh;


    @Column(name = "mota",columnDefinition = "TEXT")
    private String mota;

}