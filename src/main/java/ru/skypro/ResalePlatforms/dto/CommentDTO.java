package ru.skypro.ResalePlatforms.dto;

public class CommentDTO {
    //id автора комментария
    private int author;
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
}
