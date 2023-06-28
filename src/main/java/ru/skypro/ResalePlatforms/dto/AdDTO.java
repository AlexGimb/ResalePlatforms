package ru.skypro.ResalePlatforms.dto;

public class AdDTO {
    //id автора объявления
    private int author;
    //ссылка на картинку объявления
    private String image;
    //id объявления
    private int pk;
    //цена объявления
    private int price;
    //заголовок объявления
    private String title;

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
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
