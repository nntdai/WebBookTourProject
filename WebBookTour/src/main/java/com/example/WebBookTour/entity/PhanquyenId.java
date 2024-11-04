package com.example.WebBookTour.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PhanquyenId implements Serializable {
    private static final long serialVersionUID = 3992058910747525986L;
    @Column(name = "idChucVu", nullable = false)
    private Integer idChucVu;

    @Column(name = "idChucNangQuyen", nullable = false)
    private Integer idChucNangQuyen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PhanquyenId entity = (PhanquyenId) o;
        return Objects.equals(this.idChucVu, entity.idChucVu) &&
                Objects.equals(this.idChucNangQuyen, entity.idChucNangQuyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChucVu, idChucNangQuyen);
    }

}