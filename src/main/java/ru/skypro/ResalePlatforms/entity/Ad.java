package ru.skypro.ResalePlatforms.entity;

import ru.skypro.ResalePlatforms.dto.AdDTO;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad extends AdDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserClient author;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String title;

    @Column()
    private String description;

    public Ad(int id, UserClient author,
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public UserClient getAuthor() {
        return author;
    }

    public void setAuthor(UserClient author) {
        this.author = author;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
