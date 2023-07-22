package ru.skypro.ResalePlatforms.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.ResalePlatforms.dto.UserDetailsDTO;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private final UserDetailsDTO userDetailsDTO;

    public UserPrincipal(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority("ROLE_"+userDetailsDTO.getRole().name());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return userDetailsDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetailsDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
