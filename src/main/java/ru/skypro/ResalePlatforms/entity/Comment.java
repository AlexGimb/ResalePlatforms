package ru.skypro.ResalePlatforms.entity;

import ru.skypro.ResalePlatforms.dto.CommentDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment extends CommentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserClient author;

    @Column(nullable = false)
    private String authorImage;

    @Column(nullable = false)
    private String authorFirstName;

    @Column(nullable = false)
    private long createdAt;

    @Column(nullable = false)
    private String text;

    public Comment(int adId, UserClient author,
                   String authorImage, String authorFirstName,
                   long createdAt, String text) {
        this.adId = adId;
        this.author = author;
        this.authorImage = authorImage;
        this.authorFirstName = authorFirstName;
        this.createdAt = createdAt;
        this.text = text;
    }

    public Comment() {

    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getAdId() {
        return adId;
    }


    public UserClient getAuthor() {
        return author;
    }

    public void setAuthor(UserClient author) {
        this.author = author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return adId == comment.adId && createdAt == comment.createdAt && Objects.equals(author, comment.author) && Objects.equals(authorImage, comment.authorImage) && Objects.equals(authorFirstName, comment.authorFirstName) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, author, authorImage, authorFirstName, createdAt, text);
    }
}
