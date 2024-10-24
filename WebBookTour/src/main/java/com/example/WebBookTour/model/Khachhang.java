package com.example.WebBookTour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "khachhang")
public class Khachhang {
    @Id
    @Column(name = "soDienThoai", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "diemTichLuy", nullable = false)
    private Integer diemTichLuy;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @OneToMany(mappedBy = "sdtKhachHang")
    private Set<Datchotour> datchotours = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idKhachHang")
    private Set<Hoivien> hoiviens = new LinkedHashSet<>();

}