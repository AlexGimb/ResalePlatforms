package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.ResalePlatforms.dto.RegisterDTO;
import ru.skypro.ResalePlatforms.dto.Role;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.repository.UserRepository;
import ru.skypro.ResalePlatforms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

  private final CustomUserDetailsService userDetailsService;
  private final PasswordEncoder encoder;
  private final UserRepository userRepository;

  public AuthServiceImpl(CustomUserDetailsService userDetailsService, PasswordEncoder encoder, UserRepository userRepository) {
    this.userDetailsService = userDetailsService;
    this.encoder = encoder;
    this.userRepository = userRepository;
  }


  @Override
  public boolean login(String userName, String password) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
    return encoder.matches(password, userDetails.getPassword());
  }

  @Override
  public boolean register(RegisterDTO registerDTO, Role role) {
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