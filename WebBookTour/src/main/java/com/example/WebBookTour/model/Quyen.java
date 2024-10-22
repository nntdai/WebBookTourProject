package com.example.WebBookTour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "quyen")
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 150)
    private String ten;

    @OneToMany(mappedBy = "idQuyen")
    private Set<Chucnangquyen> chucnangquyens = new LinkedHashSet<>();

}