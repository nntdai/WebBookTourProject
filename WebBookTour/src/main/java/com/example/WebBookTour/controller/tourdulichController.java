package com.example.WebBookTour.controller;

import com.example.WebBookTour.model.tourdulichDTO;
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
    public List<tourdulichDTO> getAllTourdulich(){
        return tourService.getAllTours();
    }

    // Thêm một tour mới
//    @PostMapping("/add")
//    public ResponseEntity<tourdulichDTO> addTour(@RequestBody tourdulichDTO tour) {
//        tourdulichDTO newTour = tourService.addTour(tour);
//        return ResponseEntity.ok(newTour);
//    }

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
