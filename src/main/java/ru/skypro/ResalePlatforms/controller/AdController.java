package ru.skypro.ResalePlatforms.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdController {

    // Получить все объявления
    @GetMapping("/")
    public ResponseEntity<AdsDTO> getAllAds() {
        // Заглушка для значения по умолчанию
        AdsDTO response = new AdsDTO();
        return ResponseEntity.ok(response);
    }

    // Добавить объявление
    @PostMapping("/")
    public ResponseEntity<AdDTO> addAd(@RequestParam("image") MultipartFile image, @RequestParam("createOrUpdateAdDTO") CreateOrUpdateAdDTO createOrUpdateAdDTO) {
        // Заглушка для значения по умолчанию
        AdDTO adDTO = new AdDTO();
        return ResponseEntity.ok(adDTO);
    }
    // Получить комментарии объявления

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDTO> getAd(@PathVariable("id") int id) {
        // Логика получения информации об объявлении по его идентификатору
        ExtendedAdDTO ad = new ExtendedAdDTO();
        return ResponseEntity.ok(ad);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable("id") int id) {
        // Логика удаления объявления
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable("id") int id, @RequestBody CreateOrUpdateAdDTO ad) {
        // Логика обновления информации об объявлении
        AdDTO ads = new AdDTO();
        return ResponseEntity.ok(ads);
    }
    @PatchMapping("/{adId}/image")
    public ResponseEntity<byte[]> updateAdImage(@PathVariable("adId") int adId, @RequestParam("image") MultipartFile image) {
        // Логика обновления картинки объявления
//        byte[] imageData = adService.updateAdImage(adId, image);
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(imageData);
        return ResponseEntity.noContent().build();
    }
}
