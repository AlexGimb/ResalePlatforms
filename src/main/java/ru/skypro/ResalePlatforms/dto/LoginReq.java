package ru.skypro.ResalePlatforms.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String password;
    private String username;
}
