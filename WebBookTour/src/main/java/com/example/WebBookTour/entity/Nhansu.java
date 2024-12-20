package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "nhansu")
public class Nhansu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @Column(name = "diaChi", length = 100)
    private String diaChi;

    @Column(name = "cmnd", nullable = false, length = 12)
    private String cmnd;

    @Column(name = "soDienThoai", nullable = false, length = 12)
    private String soDienThoai;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "hinhAnh", length = 100)
    private String hinhAnh;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "idNhanVien")
    private Taikhoanadmin taikhoanadmin;

    @OneToMany(mappedBy = "idHDV")
    private Set<Tochuctour> tochuctours = new LinkedHashSet<>();

}