package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.DiadiemDto;
import com.example.WebBookTour.dto.VungmienDto;
import com.example.WebBookTour.entity.Diadiem;
import com.example.WebBookTour.entity.Vungmien;
import com.example.WebBookTour.service.DiadiemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/admin/diadiem")
public class DiadiemRestcontroller {
    @Autowired
    DiadiemService diaDiemService;

    @GetMapping
    public Page<DiadiemDto> listDiaDiem(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size, Model model)
    {
        return diaDiemService.getDiaDiems(page,size);

    }


    @PostMapping("/delete")
    public String deleteDiaDiem(@RequestBody int id)
    {
        diaDiemService.deleteDiaDiem(id);
        return "Xóa thành công ";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDiadiem(@RequestBody @Valid DiadiemDto diadiemDto, BindingResult result) throws Exception {
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

            diaDiemService.saveDiaDiem(diadiemDto);
        return ResponseEntity.ok("Địa điểm đã được thêm thành công!");



    }
    @PostMapping("/edit")
    public ResponseEntity<String> editDiadiem(@RequestBody @Valid DiadiemDto diadiemDto, BindingResult result) throws Exception {
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

        diaDiemService.updateDiaDiem(diadiemDto);
        return ResponseEntity.ok("Địa điểm đã được sửa thành công!");



    }

}
