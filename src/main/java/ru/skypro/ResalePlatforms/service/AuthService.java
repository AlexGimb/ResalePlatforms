package ru.skypro.ResalePlatforms.service;

import ru.skypro.ResalePlatforms.dto.RegisterReq;
import ru.skypro.ResalePlatforms.dto.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);
}
