package ru.skypro.ResalePlatforms.service;

import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;

public interface CommentDetailsService {


    void deleteComment(int commentId);

    CommentDTO updateComment(int adId, int commentId, CreateOrUpdateCommentDTO comment);
}
