package ru.skypro.ResalePlatforms.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class AdsController {
    // Получить все объявления
    @GetMapping("/")
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        // Заглушка для значения по умолчанию
        ResponseWrapperAds response = new ResponseWrapperAds();
        return ResponseEntity.ok(response);
    }

    // Добавить объявление
    @PostMapping("/")
    public ResponseEntity<Ads> addAd(@RequestParam("image") MultipartFile image, @RequestParam("properties") CreateAds createAds) {
        // Заглушка для значения по умолчанию
        Ads ad = new Ads();
        return ResponseEntity.ok(ad);
    }
    // Получить комментарии объявления
    @GetMapping("/{id}/comments")
    public ResponseEntity<ResponseWrapperComment> getComments(@PathVariable("id") int id) {
        // Заглушка для значения по умолчанию
        ResponseWrapperComment response = new ResponseWrapperComment();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/comments")
    public Comment addComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        // Логика добавления комментария к объявлению с заданным id
        // Возвращаем созданный комментарий (Comment) по умолчанию
        return new Comment();
    }
    @GetMapping("/{id}")
    public ResponseWrapperAds getAd(@PathVariable("id") int id) {
        // Логика получения информации об объявлении с заданным id
        // Возвращаем объячвление по умолчанию
        return new ResponseWrapperAds();
    }
    @DeleteMapping("/{id}")
    public void removeAd(@PathVariable("id") int id) {
        // Логика удаления объявления с заданным id
    }
}
