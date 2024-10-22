package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phanquyen")
public class Phanquyen {
    @EmbeddedId
    private PhanquyenId id;

    @MapsId("idChucVu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChucVu", nullable = false)
    private Chucvu idChucVu;

    @MapsId("idChucNangQuyen")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChucNangQuyen", nullable = false)
    private Chucnangquyen idChucNangQuyen;

    @Column(name = "status")
    private Boolean status;

}