package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.NhansuDto;
import com.example.WebBookTour.entity.Nhansu;
import com.example.WebBookTour.repository.NhansuRepository;
import com.example.WebBookTour.service.NhansuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/nhansu")
public class NhansuRestcontroller {

    @Autowired
    private NhansuService nhansuService;

    @GetMapping("/getall")
    public List<NhansuDto> getAll()
        {
            return nhansuService.getAllHDV();
        }
    @PutMapping("/edit")
    public ResponseEntity<String> editDiadiem(@RequestBody @Valid NhansuDto nhansuDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            // Duyệt qua các lỗi và thêm chúng vào StringBuilder
            result.getFieldErrors().forEach(error -> {
                errorMessages.append(
//                                error.getField())           // take field name error
//                                .append(": ")
//                                .append
                                error.getDefaultMessage())            //take message error
                        .append("\n");

            });
            return ResponseEntity.badRequest().body(errorMessages.toString());              // notice 404 bad request and message error to Ajax
        }
        nhansuService.updateNhansu(nhansuDto);
        return ResponseEntity.ok("Địa điểm đã được sửa thành công!");
    }

}
