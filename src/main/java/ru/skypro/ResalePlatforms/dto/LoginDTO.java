package ru.skypro.ResalePlatforms.dto;

import lombok.Data;

@Data
public class LoginDTO {
    //пароль
    private String password;
    //логин
    private String username;
}
