package ru.skypro.ResalePlatforms.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.exception.ImageUploadException;
import ru.skypro.ResalePlatforms.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String UPLOAD_DIR = "upload-directory";

    private static final String BASE_URL = "http://localhost:8080/api/images";

    @Override
    public String uploadImage(MultipartFile image) {
        try {
            String fileName = generateUniqueFileName(image.getOriginalFilename());
            String filePath = getUploadDirectory() + File.separator + fileName;
            File destFile = new File(filePath);
            image.transferTo(destFile);
            String imageUrl = BASE_URL + "/images/" + fileName; // Формирование URL-адреса изображения
            return imageUrl;
        } catch (IOException e) {
            throw new ImageUploadException("Failed to upload image", e);
        }
    }
    @Override
    public String generateUniqueFileName(String originalFileName) {
        String baseName = FilenameUtils.getBaseName(originalFileName);
        String extension = FilenameUtils.getExtension(originalFileName);
        String uniqueName = UUID.randomUUID().toString();
        return baseName + "_" + uniqueName + "." + extension;
    }

    @Override
    public String getUploadDirectory() {
        String uploadPath = System.getProperty("user.dir") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        return uploadPath;
    }

    @Override
    public Resource loadImageResource(String fileName) {
        try {
            String filePath = getUploadDirectory() + File.separator + fileName;
            Path imagePath = Paths.get(filePath);
            Resource imageResource = new UrlResource(imagePath.toUri());

            if (imageResource.exists() && imageResource.isReadable()) {
                return imageResource;
            } else {
                throw new ImageUploadException("Изображение не найдено или не может быть прочитано");
            }
        } catch (MalformedURLException e) {
            throw new ImageUploadException("Ошибка загрузки изображения", e);
        }
    }
}
