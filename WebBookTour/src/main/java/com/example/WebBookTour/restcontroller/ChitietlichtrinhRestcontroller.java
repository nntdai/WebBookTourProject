package com.example.WebBookTour.restcontroller;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;

import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.service.ChitietlichtrinhService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/admin/lichtrinh")
public class ChitietlichtrinhRestcontroller {
    @Autowired
    private ChitietlichtrinhService chitietlichtrinhService;


    @PostMapping("/add")
    public List<Chitietlichtrinh> addChiTietLichTrinh( @RequestParam("lichTrinhList") String lichTrinhList,
                                                       @RequestParam("files") List<MultipartFile> files) throws JsonProcessingException {

        // Parse JSON danh sách từ chuỗi
        ObjectMapper objectMapper = new ObjectMapper();
        List<ChitietlichtrinhDto> chitietlichtrinhDtoList = objectMapper.readValue(
                lichTrinhList,
                objectMapper.getTypeFactory().constructCollectionType(List.class, ChitietlichtrinhDto.class));

        for (int i = 0; i < chitietlichtrinhDtoList.size(); i++) {
            ChitietlichtrinhDto cDto = chitietlichtrinhDtoList.get(i);
            cDto.setHinhAnh(chitietlichtrinhService.uploadFile(files.get(i)));

        }
//        for (MultipartFile file : files) {
//            System.out.println("File nhận được: " + file.getOriginalFilename());
//        }
        return chitietlichtrinhService.saveListLichTrinh(chitietlichtrinhDtoList);
    }
}
