package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chucvu")
public class Chucvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 150)
    private String ten;

    @OneToMany(mappedBy = "idChucVu")
    private Set<model.Phanquyen> phanquyens = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idChucVu")
    private Set<model.Taikhoanadmin> taikhoanadmins = new LinkedHashSet<>();

}