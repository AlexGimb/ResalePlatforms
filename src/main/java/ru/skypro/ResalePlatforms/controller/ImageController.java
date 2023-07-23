package ru.skypro.ResalePlatforms.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.exception.ImageUploadException;
import ru.skypro.ResalePlatforms.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable("fileName") String fileName) {
        Resource imageResource = imageService.loadImageResource(fileName);
        try {
            byte[] imageBytes = FileCopyUtils.copyToByteArray(imageResource.getInputStream());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new ImageUploadException("Error reading image", e);
        }
    }

    @PostMapping
    public String uploadImage(@RequestParam("image") MultipartFile image) {
        return imageService.uploadImage(image);
    }
}

