package com.example.WebBookTour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diadiem")
public class Diadiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 100)
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVungMien")
    private com.example.WebBookTour.model.Vungmien idVungMien;

    @OneToMany(mappedBy = "diaDiemKH")
    private Set<Tourdulich> tourduliches = new LinkedHashSet<>();

    @OneToMany(mappedBy = "diaDiemThamQuan")
    private Set<Tourdulich> tourduliches2 = new LinkedHashSet<>();

}