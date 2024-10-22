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
public class PhanquyenId implements java.io.Serializable {
    private static final long serialVersionUID = 4814713587081079616L;
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