package ru.skypro.ResalePlatforms.service;

import ru.skypro.ResalePlatforms.dto.RegisterDTO;
import ru.skypro.ResalePlatforms.dto.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterDTO registerDTO, Role role);
}
