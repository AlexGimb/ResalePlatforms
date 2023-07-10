package ru.skypro.ResalePlatforms.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.NewPasswordDTO;
import ru.skypro.ResalePlatforms.dto.UpdateUserDTO;
import ru.skypro.ResalePlatforms.entity.UserClient;

public interface UserService {
    NewPasswordDTO setPassword(NewPasswordDTO newPassword);

    UserClient getAuthenticatedUser();

    UpdateUserDTO updateUser(UpdateUserDTO updateUser);

    void updateUserImage(MultipartFile image);
}

