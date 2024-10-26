package com.example.WebBookTour.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tourdulich")
public class tourdulichController {
    @GetMapping("") //http://localhost:8088/api/tourdulich
    public ResponseEntity<String> getAllTourdulich(){
        return ResponseEntity.ok("chao ban, haha");
    }

    @PostMapping("")
    public ResponseEntity<String> insertTourdulich(){
        return ResponseEntity.ok("This is insertTour");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTourdulich(@PathVariable Long id){
        return ResponseEntity.ok("updateTourdulich with id = " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourdulich(@PathVariable Long id){
        return ResponseEntity.ok("deleteTourdulich with id = " + id);
    }
}
