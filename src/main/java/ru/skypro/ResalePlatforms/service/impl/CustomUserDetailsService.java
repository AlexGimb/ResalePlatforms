package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.repository.UserRepository;

import javax.persistence.Cacheable;

@Service
@Cacheable
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserClient user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким именем: " + username + " не найден"));
//        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getUsername(), user.getPassword(),
                true, true, true, true, AuthorityUtils.createAuthorityList(user.getRole().toString()));
    }

}
