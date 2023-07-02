package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.NewPasswordDTO;
import ru.skypro.ResalePlatforms.dto.UpdateUserDTO;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<String> setPassword(@RequestBody NewPasswordDTO newPasswordDTO) {
        userService.setPassword(newPasswordDTO);
        return ResponseEntity.ok("Пароль обновлен");
    }

    // Получить информацию об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<UserClient> getUser() {
        UserClient userClient = userService.getAuthenticatedUser();
        return ResponseEntity.ok(userClient);
    }

    // Обновить информацию об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        UpdateUserDTO updateUser = userService.updateUser(updateUserDTO);
        return ResponseEntity.ok(updateUser);
    }

    // Обновить аватар авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("image") MultipartFile image) {
        // Заглушка для значения по умолчанию
        userService.updateUserImage(image);
        return ResponseEntity.ok("User image updated");
    }
}
