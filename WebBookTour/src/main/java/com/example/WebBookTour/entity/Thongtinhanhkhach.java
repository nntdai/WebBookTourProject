package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "thongtinhanhkhach")
public class Thongtinhanhkhach {
    @EmbeddedId
    private ThongtinhanhkhachId id;

    @MapsId("idDatCho")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idDatCho", nullable = false)
    private Tourdulich idDatCho;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhomTuoi")
    private Nhomtuoi nhomTuoi;

}