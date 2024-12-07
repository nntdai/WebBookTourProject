package com.example.WebBookTour.repository;

import com.example.WebBookTour.entity.Datchotour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DatchotourRepository extends JpaRepository<Datchotour, Integer> {

    @Query(value = "SELECT d.* "
    + "FROM datchotour d "
    + "LEFT JOIN tochuctour t ON d.idToChucTour = t.id "
    + "LEFT JOIN tourdulich td ON t.idTourDuLich = td.id "
    + "LEFT JOIN khuyenmai km ON d.idKhuyenMai = km.id "
    + "LEFT JOIN khachhang k ON d.sdtKhachHang = k.soDienThoai "
            + "WHERE "
    + "d.id LIKE %:keyword% OR "
    + "d.tongTien LIKE %:keyword% OR "
    + "d.ngayDatCho LIKE %:keyword% OR "
    + "d.diemTLCong LIKE %:keyword% OR "
    + "d.diemTLDung LIKE %:keyword% OR "
    + "d.sdtKhachHang LIKE %:keyword% OR "
    + "td.ten LIKE %:keyword% OR "
    + "km.ten LIKE %:keyword%", countQuery = "SELECT COUNT(*) FROM datchotour d "
            + "LEFT JOIN tochuctour t ON d.idToChucTour = t.id "
            + "LEFT JOIN tourdulich td ON t.idTourDuLich = td.id "
            + "LEFT JOIN khuyenmai km ON d.idKhuyenMai = km.id "
            + "LEFT JOIN khachhang k ON d.sdtKhachHang = k.soDienThoai "
            + "WHERE d.id LIKE %:keyword% OR "
            + "d.tongTien LIKE %:keyword% OR "
            + "d.ngayDatCho LIKE %:keyword% OR "
            + "d.diemTLCong LIKE %:keyword% OR "
            + "d.diemTLDung LIKE %:keyword% OR "
            + "d.sdtKhachHang LIKE %:keyword% OR "
            + "td.ten LIKE %:keyword% OR "
            + "km.ten LIKE %:keyword%",nativeQuery = true)
    Page<Datchotour> searchDatchoTourByKeyword(@Param("keyword") String keyword, Pageable pageable);
    @Query(value = "SELECT d.* "
            + "FROM datchotour d "
            + "LEFT JOIN tochuctour t ON d.idToChucTour = t.id "
            + "LEFT JOIN tourdulich td ON t.idTourDuLich = td.id "
            + "LEFT JOIN khuyenmai km ON d.idKhuyenMai = km.id "
            + "LEFT JOIN khachhang k ON d.sdtKhachHang = k.soDienThoai "
            + "WHERE "
            + "(d.id LIKE %:matour% OR :matour is null) AND "
            + "(d.sdtKhachHang LIKE %:sdt% OR :sdt is null) AND  "
            + "(td.id LIKE %:tourdl% OR :tourdl is null) ", countQuery = "SELECT COUNT(*) FROM datchotour d "
            + "LEFT JOIN tochuctour t ON d.idToChucTour = t.id "
            + "LEFT JOIN tourdulich td ON t.idTourDuLich = td.id "
            + "LEFT JOIN khuyenmai km ON d.idKhuyenMai = km.id "
            + "LEFT JOIN khachhang k ON d.sdtKhachHang = k.soDienThoai "
            + "WHERE (d.id LIKE %:matour% OR :matour is null) AND "
            + "(d.sdtKhachHang LIKE %:sdt% OR :sdt is null) AND  "
            + "(td.id LIKE %:tourdl% OR :tourdl is null) ",nativeQuery = true)
    Page<Datchotour> searchDatchoTour(@Param("matour") String matour,
                                      @Param("sdt") String sdt,
                                      @Param("tourdl") String tourdl,
                                      Pageable pageable);
}
