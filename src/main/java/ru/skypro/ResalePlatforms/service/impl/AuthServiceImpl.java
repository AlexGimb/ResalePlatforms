package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.ResalePlatforms.dto.RegisterDTO;
import ru.skypro.ResalePlatforms.dto.Role;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.repository.UserRepository;
import ru.skypro.ResalePlatforms.service.AuthService;
import ru.skypro.ResalePlatforms.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserServiceImpl userService;
  private final PasswordEncoder encoder;

  private final UserRepository userRepository;

  public AuthServiceImpl(UserServiceImpl userService, PasswordEncoder encoder, UserRepository userRepository) {
    this.userService = userService;
    this.encoder = encoder;
    this.userRepository = userRepository;
  }

  @Override
  public boolean login(String username, String password) {

    if (!userService.userExists(username)) {
      return false;
    }
    UserDetails userDetails = userService.loadUserByUsername(username);
    return encoder.matches(password, userDetails.getPassword());
  }

  @Override
  public boolean register(RegisterDTO registerDTO, Role role) {
    if (userService.userExists(registerDTO.getUsername())) {
      return false;
    }
    UserClient userClient = new UserClient();
    userClient.setUsername(registerDTO.getUsername());
    userClient.setPassword(encoder.encode(registerDTO.getPassword()));
    userClient.setFirstName(registerDTO.getFirstName());
    userClient.setLastName(registerDTO.getLastName());
    userClient.setPhone(registerDTO.getPhone());
    userClient.setRole(role);
    userRepository.save(userClient);
    return true;
  }
}
