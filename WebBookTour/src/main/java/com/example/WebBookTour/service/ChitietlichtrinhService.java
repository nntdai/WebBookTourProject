package com.example.WebBookTour.service;

import com.example.WebBookTour.dto.ChitietlichtrinhDto;
import com.example.WebBookTour.entity.Chitietlichtrinh;
import com.example.WebBookTour.entity.Tourdulich;
import com.example.WebBookTour.mapper.ChitietlichtrinhMapper;
import com.example.WebBookTour.repository.ChitietlichtrinhRepository;
import com.example.WebBookTour.repository.TourdulichRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChitietlichtrinhService {

    @Autowired
    private ChitietlichtrinhRepository chitietlichtrinhRepository;

    @Autowired
    private TourdulichRepository tourdulichRepository;

    @Autowired
    private ChitietlichtrinhMapper chitietlichtrinhMapper;

    @Autowired
    private S3Client s3Client;

    private final String bucketName = "webbooktourimg";
    private final String imgS3="https://webbooktourimg.s3.<region>.amazonaws.com";

    public String uploadFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(fileName)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
            );
            return fileName; // Trả về tên file đã upload
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file: " + e.getMessage());
        }
    }

    public List<Chitietlichtrinh> saveListLichTrinh(List<ChitietlichtrinhDto> chitietlichtrinhDtoList)
    {
        List<Chitietlichtrinh> chitietlichtrinhList = chitietlichtrinhMapper.toEntityList(chitietlichtrinhDtoList);
        for (Chitietlichtrinh chitietlichtrinh : chitietlichtrinhList) {
            if (chitietlichtrinh.getId().getIdTour() != null) {
                Tourdulich tourdulich = tourdulichRepository.findById(chitietlichtrinh.getId().getIdTour())
                        .orElseThrow(() -> new RuntimeException("Tour not found"));
                chitietlichtrinh.setIdTour(tourdulich); // Gán đúng đối tượng Tourdulich
            }
        }
        return chitietlichtrinhRepository.saveAll(chitietlichtrinhList);

    }
}
