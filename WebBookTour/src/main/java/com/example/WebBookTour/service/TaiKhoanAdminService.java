package com.example.WebBookTour.service;

import com.example.WebBookTour.entity.Taikhoanadmin;
import com.example.WebBookTour.repository.TaiKhoanAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaiKhoanAdminService implements UserDetailsService {
    private final TaiKhoanAdminRepository taiKhoanAdminRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Taikhoanadmin> taiKhoan = taiKhoanAdminRepository.findByUsername(username);
        if (taiKhoan.isPresent())
        {
            return taiKhoan.get();
        }
        throw new UsernameNotFoundException(username);
    }

    public Optional<Taikhoanadmin> getTaikhoanByUsername(String user) {
        return taiKhoanAdminRepository.findByUsername(user);
    }
}
