package ru.skypro.ResalePlatforms.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int author;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public Ad(int id, int author,
              String image, int price,
              String title, String description) {
        this.id = id;
        this.author = author;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public Ad() {

    }

    public int getId() {
        return id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id && author == ad.author && price == ad.price && Objects.equals(image, ad.image) && Objects.equals(title, ad.title) && Objects.equals(description, ad.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, image, price, title, description);
    }
}
