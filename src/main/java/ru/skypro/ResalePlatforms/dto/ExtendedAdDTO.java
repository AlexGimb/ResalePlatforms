package ru.skypro.ResalePlatforms.dto;

public class ExtendedAdDTO {
    //id объявления
    private int pk;
    //имя автора объявления
    private String authorFirstName;
    //фамилия автора объявления
    private String authorLastName;
    //описание объявления
    private String description;
    //логин автора объявления
    private String email;
    //ссылка на картинку объявления
    private String image;
    //телефон автора объявления
    private String phone;
    //цена объявления
    private int price;
    //заголовок объявления
    private String title;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
