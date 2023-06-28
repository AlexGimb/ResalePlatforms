package ru.skypro.ResalePlatforms.dto;

public class NewPasswordDTO {
    //текущий пароль
    private String currentPassword;
    //новый пароль
    private String newPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
