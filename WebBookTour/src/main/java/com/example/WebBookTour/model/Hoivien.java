package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "hoivien")
public class Hoivien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang")
    private model.Khachhang idKhachHang;

    @Column(name = "ngaySinh", nullable = false)
    private Instant ngaySinh;

    @Column(name = "cmnd", nullable = false)
    private Integer cmnd;

    @Column(name = "diaChi", nullable = false, length = 70)
    private String diaChi;

    @Column(name = "ngayTao", nullable = false)
    private Instant ngayTao;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

}