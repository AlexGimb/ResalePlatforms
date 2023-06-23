package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.NewPassword;
import ru.skypro.ResalePlatforms.dto.User;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {
    // Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<String> setPassword(@RequestBody NewPassword newPassword) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok("Password updated");
    }

    // Получить информацию об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        // Заглушка для значения по умолчанию
        User user = new User();
        return ResponseEntity.ok(user);
    }

    // Обновить информацию об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok(user);
    }

    // Обновить аватар авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("image") MultipartFile image) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok("User image updated");
    }
}
