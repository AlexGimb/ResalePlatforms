package ru.skypro.ResalePlatforms.dto;

import ru.skypro.ResalePlatforms.entity.UserClient;

public class CommentDTO {
    //id автора комментария
    private UserClient author;
    //ссылка на аватар автора комментария
    private String authorImage;
    //имя создателя комментария
    private String authorFirstname;
    //дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    private long createAt;
    //id комментария
    private int pk;
    //текст комментария
    private String text;

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

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
