package ru.skypro.ResalePlatforms.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.service.ImageService;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable("fileName") String fileName) {
        Resource imageResource = imageService.loadImageResource(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Измените MediaType в зависимости от типа сохраняемых изображений
                .body(imageResource);
    }

    @PostMapping
    public String uploadImage(@RequestParam("image") MultipartFile image) {
        return imageService.uploadImage(image);
    }
}

