package com.example.WebBookTour.controller;

import com.example.WebBookTour.dto.TourdulichDto;
import com.example.WebBookTour.exceptions.DataNotFoundException;
import com.example.WebBookTour.service.tourdulichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tourdulich")
public class tourdulichController {

    @Autowired
    private tourdulichService tourService;

    // Lấy danh sách tất cả các tour
    @GetMapping("/all") //http://localhost:8088/api/tourdulich
    public List<TourdulichDto> getAllTourdulich(){
        return tourService.getAllTours();
    }

    // Thêm một tour mới
    @PostMapping("/add")
    public ResponseEntity<?> addTour(@RequestBody TourdulichDto tour) {
        try {
            tourService.addTour(tour);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("da tao moi tourdulich");
    }

    // Cập nhật một tour
//    @PutMapping("/update/{id}")
//    public ResponseEntity<tourdulichDTO> updateTour(@PathVariable Long id, @RequestBody tourdulichDTO updatedTour) {
//        return tourService.updateTour(id, updatedTour)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    // Xóa một tour
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
//        if (tourService.deleteTour(id)) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
