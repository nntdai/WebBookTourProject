package com.example.WebBookTour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"diadiems"})
@Entity
@Table(name = "vungmien")
public class Vungmien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 100)
    private String ten;
    @JsonManagedReference
    @OneToMany(mappedBy = "idVungMien",fetch = FetchType.LAZY)            //Bo di vi tranh bi lap
    private Set<Diadiem> diadiems;

}