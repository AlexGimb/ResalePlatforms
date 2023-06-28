package ru.skypro.ResalePlatforms.dto;

import lombok.Data;

@Data
public class LoginDTO {
    //пароль
    private String password;
    //логин
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
