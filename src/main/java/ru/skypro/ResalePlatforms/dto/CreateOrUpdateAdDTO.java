package ru.skypro.ResalePlatforms.dto;

public class CreateOrUpdateAdDTO {

    //заголовок объявления
    private String title;
    //описание объявления
    private String description;
    //цена объявления
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
