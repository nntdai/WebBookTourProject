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
public class ThongtinhanhkhachId implements java.io.Serializable {
    private static final long serialVersionUID = 4423527066785411268L;
    @Column(name = "idDatCho", nullable = false)
    private Integer idDatCho;

    @Column(name = "tenHanhKhach", nullable = false)
    private Integer tenHanhKhach;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ThongtinhanhkhachId entity = (ThongtinhanhkhachId) o;
        return Objects.equals(this.tenHanhKhach, entity.tenHanhKhach) &&
                Objects.equals(this.idDatCho, entity.idDatCho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenHanhKhach, idDatCho);
    }

}