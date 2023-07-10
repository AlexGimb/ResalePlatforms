package ru.skypro.ResalePlatforms.dto;

import ru.skypro.ResalePlatforms.entity.Comment;

import java.util.List;

public class CommentsDTO {
    //общее количество комментариев
    private int count;
    //лист всех комментарии
    private List<Comment> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Comment> getResults() {
        return results;
    }

    public void setResults(List<Comment> results) {
        this.results = results;
    }
}
