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

@Service
public class AuthServiceImpl implements AuthService {

  private final UserDetailsManager manager;
  private final PasswordEncoder encoder;

  private final UserRepository userRepository;

  public AuthServiceImpl(UserDetailsManager manager,
                         PasswordEncoder passwordEncoder,
                         UserRepository userRepository) {
    this.manager = manager;
    this.encoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @Override
  public boolean login(String userName, String password) {
    if (!manager.userExists(userName)) {
      return false;
    }
    UserDetails userDetails = manager.loadUserByUsername(userName);
    return encoder.matches(password, userDetails.getPassword());
  }

  @Override
  public boolean register(RegisterDTO registerDTO, Role role) {
    if (manager.userExists(registerDTO.getUsername())) {
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

    manager.createUser(
            User.builder()
                    .passwordEncoder(this.encoder::encode)
                    .password(registerDTO.getPassword())
                    .username(registerDTO.getUsername())
                    .roles(role.name())
                    .build());

    return true;
  }
}
