package ru.skypro.ResalePlatforms.service;

import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CommentsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;

public interface CommentService {

    CommentsDTO getCommentsByAd(int adId);

    CommentDTO addComment(int adId, CreateOrUpdateCommentDTO comment);
}
