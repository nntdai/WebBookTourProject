package com.example.WebBookTour.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ChitietlichtrinhId implements Serializable {
    private static final long serialVersionUID = -4232565368626133586L;
    @NotNull
    @Column(name = "idTour", nullable = false)
    private Integer idTour;

    @NotNull
    @Column(name = "ngayThu", nullable = false)
    private Integer ngayThu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChitietlichtrinhId entity = (ChitietlichtrinhId) o;
        return Objects.equals(this.idTour, entity.idTour) &&
                Objects.equals(this.ngayThu, entity.ngayThu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTour, ngayThu);
    }

}