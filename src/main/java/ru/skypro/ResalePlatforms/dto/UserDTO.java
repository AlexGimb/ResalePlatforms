package ru.skypro.ResalePlatforms.dto;

public class UserDTO {
    //id пользователя
    private int id;
    //логин пользователя
    private String username;
    //пароль
    private String password;
    //имя пользователя
    private String firstName;
    //фамилия пользователя
    private String lastName;
    //телефон пользователя
    private String phone;
    //ссылка на аватар пользователя
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
