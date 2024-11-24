package com.example.WebBookTour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"idVungMien"})
@Entity
@Table(name = "diadiem")
public class Diadiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 100)
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY)       //Eager : chỉ lấy tới vungmien và không bị lặo
    @JoinColumn(name = "idVungMien")
    @JsonBackReference
    private Vungmien idVungMien;

//    @OneToMany(mappedBy = "diaDiemKH")
//    private Set<Tourdulich> tourduliches = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "diaDiemThamQuan")
//    private Set<Tourdulich> tourduliches2 = new LinkedHashSet<>();

}