package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.ResalePlatforms.dto.AdsDTO;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class UserAdController {

    @GetMapping("/me")
    public ResponseEntity<AdsDTO> getAdsByUser() {
        // Логика получения объявлений авторизованного пользователя
        AdsDTO ads = new AdsDTO();
        return ResponseEntity.ok(ads);
    }

}
