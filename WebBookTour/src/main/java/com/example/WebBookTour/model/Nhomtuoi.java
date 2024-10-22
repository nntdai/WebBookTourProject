package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "nhomtuoi")
public class Nhomtuoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 50)
    private String ten;

    @Column(name = "tuoiTu")
    private Integer tuoiTu;

    @Column(name = "tuoiDen")
    private Integer tuoiDen;

    @Column(name = "phanTram")
    private Integer phanTram;

    @OneToMany(mappedBy = "nhomTuoi")
    private Set<model.Thongtinhanhkhach> thongtinhanhkhaches = new LinkedHashSet<>();

}