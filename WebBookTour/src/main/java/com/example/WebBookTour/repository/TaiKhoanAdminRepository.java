package com.example.WebBookTour.repository;

import com.example.WebBookTour.model.Taikhoanadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanAdminRepository extends JpaRepository<Taikhoanadmin, Integer> {
    Optional<Taikhoanadmin> findByUsername(String username);
}
