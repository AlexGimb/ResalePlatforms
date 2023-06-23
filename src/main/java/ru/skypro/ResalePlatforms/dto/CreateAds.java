package ru.skypro.ResalePlatforms.dto;

import java.util.Objects;

public class CreateAds {

    private String title;
    private String description;

    public CreateAds(String title, String description) {
        this.title = title;
        this.description = description;
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
        CreateAds createAds = (CreateAds) o;
        return Objects.equals(title, createAds.title) && Objects.equals(description, createAds.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
