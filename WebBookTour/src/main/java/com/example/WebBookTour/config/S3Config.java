package com.example.WebBookTour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {       // Lưu ý không up github có chứa 2 thông tin accessKey và secretKey vì có thể gây lỗi khi push github
    String accessKey = ""; // Nhập accessKey ở đây
    String secretKey = "";  // Nhập secretKey ở đây
    AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
    String regionName = "ap-southeast-1";
    @Bean
    public S3Client s3Client() {

        return S3Client.builder()
                .region(Region.of(regionName))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
