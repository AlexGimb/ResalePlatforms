package ru.skypro.ResalePlatforms.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.AdDTO;
import ru.skypro.ResalePlatforms.dto.AdsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateAdDTO;
import ru.skypro.ResalePlatforms.dto.ExtendedAdDTO;
import ru.skypro.ResalePlatforms.service.AdService;
import ru.skypro.ResalePlatforms.service.ImageService;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class  AdController {

    private final AdService adService;
    private final ImageService imageService;

    public AdController(AdService adService, ImageService imageService) {
        this.adService = adService;
        this.imageService = imageService;
    }


    @GetMapping
    public ResponseEntity<AdsDTO> getAllAds() {
        // Логика получения всех объявлений
        AdsDTO ads = adService.getAllAds();
        return ResponseEntity.ok(ads);
    }

    @PostMapping
    public ResponseEntity<AdDTO> addAd(@RequestPart("image") MultipartFile image, @RequestPart("properties") CreateOrUpdateAdDTO ad) {
        // Логика добавления объявления
        AdDTO createdAd = adService.addAd(image, ad);
        return ResponseEntity.ok(createdAd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDTO> getAd(@PathVariable("id") int id) {
        // Логика получения информации об объявлении по его идентификатору
        ExtendedAdDTO extendedAd = adService.getAdById(id);
        return ResponseEntity.ok(extendedAd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable("id") int id) {
        // Логика удаления объявления
        adService.removeAd(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable("id") int id, @RequestBody CreateOrUpdateAdDTO ad) {
        // Логика обновления информации об объявлении
        AdDTO updatedAd = adService.updateAd(id, ad);
        return ResponseEntity.ok(updatedAd);
    }

    @PatchMapping("/{adId}/image")
    public ResponseEntity<byte[]> updateAdImage(@PathVariable("adId") int adId, @RequestPart("image") MultipartFile image) {
        byte[] updatedImage = adService.updateAdImage(adId, image);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(updatedImage, headers, HttpStatus.OK);
    }
}

