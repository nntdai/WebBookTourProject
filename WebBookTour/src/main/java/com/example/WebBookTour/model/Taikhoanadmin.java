package com.example.WebBookTour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "taikhoanadmin")
public class Taikhoanadmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "ngayCap")
    private Instant ngayCap;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChucVu", nullable = false)
    private Chucvu idChucVu;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idNhanVien", nullable = false)
    private Nhansu idNhanVien;

}