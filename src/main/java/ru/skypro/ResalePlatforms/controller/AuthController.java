package ru.skypro.ResalePlatforms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.ResalePlatforms.dto.LoginDTO;
import ru.skypro.ResalePlatforms.dto.RegisterDTO;
import ru.skypro.ResalePlatforms.dto.Role;
import ru.skypro.ResalePlatforms.service.AuthService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        if (authService.login(loginDTO.getUsername(), loginDTO.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        Role role = registerDTO.getRole() == null ? Role.USER : registerDTO.getRole();
        if (authService.register(registerDTO, role)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
