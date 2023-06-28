package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.NewPasswordDTO;
import ru.skypro.ResalePlatforms.dto.UpdateUserDTO;
import ru.skypro.ResalePlatforms.dto.UserDTO;
import ru.skypro.ResalePlatforms.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    // Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<String> setPassword(@RequestBody NewPasswordDTO newPasswordDTO) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok("Password updated");
    }

    // Получить информацию об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser() {
        // Заглушка для значения по умолчанию
        UserDTO userDTO = new UserDTO();
        return ResponseEntity.ok(userDTO);
    }

    // Обновить информацию об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok(updateUserDTO);
    }

    // Обновить аватар авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("image") MultipartFile image) {
        // Заглушка для значения по умолчанию
        return ResponseEntity.ok("User image updated");
    }
}
