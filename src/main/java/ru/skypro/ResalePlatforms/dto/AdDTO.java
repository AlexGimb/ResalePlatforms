package ru.skypro.ResalePlatforms.dto;

import ru.skypro.ResalePlatforms.entity.UserClient;

public class AdDTO {
    //id автора объявления
    private UserClient author;
    //ссылка на картинку объявления
    private String image;
    //id объявления
    private int pk;
    //цена объявления
    private int price;
    //заголовок объявления
    private String title;

    private String description;

    public void setAuthor(UserClient author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserClient getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
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
