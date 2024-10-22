package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ChitietlichtrinhId implements java.io.Serializable {
    private static final long serialVersionUID = -8525605432539621567L;
    @Column(name = "idTour", nullable = false)
    private Integer idTour;

    @Column(name = "tenChiTiet", nullable = false, length = 50)
    private String tenChiTiet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChitietlichtrinhId entity = (ChitietlichtrinhId) o;
        return Objects.equals(this.idTour, entity.idTour) &&
                Objects.equals(this.tenChiTiet, entity.tenChiTiet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTour, tenChiTiet);
    }

}