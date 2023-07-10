package ru.skypro.ResalePlatforms.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {


    String uploadImage(MultipartFile image);

    String generateUniqueFileName(String originalFileName);

    String getUploadDirectory();

    Resource loadImageResource(String fileName);
}
