package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.ResalePlatforms.dto.NewPasswordDTO;
import ru.skypro.ResalePlatforms.dto.UpdateUserDTO;
import ru.skypro.ResalePlatforms.dto.UserDetailsDTO;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.entity.UserPrincipal;
import ru.skypro.ResalePlatforms.repository.UserRepository;
import ru.skypro.ResalePlatforms.service.ImageService;
import ru.skypro.ResalePlatforms.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final ImageService imageService;


    public UserServiceImpl(UserRepository userRepository, ImageService imageService) {
        this.userRepository = userRepository;
        this.imageService = imageService;
    }

    /**
     * Возвращает информацию о текущем аутентифицированном пользователе.
     *
     * @return объект User с информацией о пользователе
     */
    @Override
    public UserClient getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<UserClient> optionalUserClient = userRepository.findByUsername(email);
        if (optionalUserClient.isPresent()) {
            return optionalUserClient.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    /**
     * Обновляет информацию о текущем пользователе.
     *
     * @param updateUser объект UpdateUser с обновленными данными пользователя
     * @return объект UpdateUser с обновленными данными пользователя
     */
    @Override
    public UpdateUserDTO updateUser(UpdateUserDTO updateUser) {
        UserClient authenticatedUserClient = getAuthenticatedUser();
        authenticatedUserClient.setFirstName(updateUser.getFirstName());
        authenticatedUserClient.setLastName(updateUser.getLastName());
        authenticatedUserClient.setPhone(updateUser.getPhone());
        // Дополнительные поля для обновления информации о пользователе
        UserClient updatedUserClient = userRepository.save(authenticatedUserClient);
        UpdateUserDTO response = new UpdateUserDTO();
        response.setFirstName(updatedUserClient.getFirstName());
        response.setLastName(updatedUserClient.getLastName());
        response.setPhone(updatedUserClient.getPhone());
        return response;
    }

    /**
     * Устанавливает новый пароль для пользователя.
     *
     * @param newPassword объект NewPassword с данными нового пароля
     * @return
     */
    @Override
    public NewPasswordDTO setPassword(NewPasswordDTO newPassword) {
        UserClient authenticatedUserClient = getAuthenticatedUser();
        authenticatedUserClient.setPassword(newPassword.getNewPassword());
        UserClient updatedUserClient = userRepository.save(authenticatedUserClient);
        UpdateUserDTO response = new UpdateUserDTO();
        response.setPassword(updatedUserClient.getPassword());
        return new NewPasswordDTO();
    }

    /**
     * Обновляет изображение пользователя.
     *
     * @param image файл изображения для обновления
     */
    @Override
    public void updateUserImage(MultipartFile image) {
        UserClient authenticatedUserClient = getAuthenticatedUser();
        // Загружаем изображение на сервер или в облачное хранилище и получаем URL
        String imageUrl = imageService.uploadImage(image);
        authenticatedUserClient.setImage(imageUrl);
        userRepository.save(authenticatedUserClient);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserClient userClient = userRepository.findByUsername(username).orElseThrow();
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userClient.getUsername(),userClient.getPassword(),userClient.getId(),userClient.getRole());
        return new UserPrincipal(userDetailsDTO);
    }
    public boolean userExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }
}
