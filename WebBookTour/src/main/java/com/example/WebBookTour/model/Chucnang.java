package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chucnang")
public class Chucnang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 150)
    private String ten;

    @OneToMany(mappedBy = "idChucNang")
    private Set<model.Chucnangquyen> chucnangquyens = new LinkedHashSet<>();

}