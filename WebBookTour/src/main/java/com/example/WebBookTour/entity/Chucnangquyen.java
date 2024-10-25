package com.example.WebBookTour.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chucnangquyen")
public class Chucnangquyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChucNang", nullable = false)
    private Chucnang idChucNang;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idQuyen", nullable = false)
    private Quyen idQuyen;

    @OneToMany(mappedBy = "idChucNangQuyen")
    private Set<Phanquyen> phanquyens = new LinkedHashSet<>();

}