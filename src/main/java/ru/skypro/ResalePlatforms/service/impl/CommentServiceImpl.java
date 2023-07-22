package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CommentsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;
import ru.skypro.ResalePlatforms.entity.Comment;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.repository.CommentRepository;
import ru.skypro.ResalePlatforms.service.CommentService;
import ru.skypro.ResalePlatforms.service.UserService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    /**
     * Получает комментарии для указанного объявления.
     *
     * @param adId идентификатор объявления
     * @return объект Comments с информацией о комментариях
     */
    @Override
    public CommentsDTO getCommentsByAd(int adId) {
        List<Comment> commentList = commentRepository.findByAdId(adId);
        int totalCount = commentList.size();

        CommentsDTO comments = new CommentsDTO();
        comments.setCount(totalCount);
        comments.setResults(commentList);

        return comments;
    }

    /**
     * Добавляет новый комментарий к указанному объявлению.
     *
     * @param adId    идентификатор объявления
     * @param comment объект CreateOrUpdateComment с данными комментария
     * @return объект Comment с информацией о добавленном комментарии
     */
    @Override
    public CommentDTO addComment(int adId, CreateOrUpdateCommentDTO comment) {
        UserClient authenticatedUser = userService.getAuthenticatedUser();

        Comment newComment = new Comment();
        newComment.setPk(adId);
        newComment.setAuthor(authenticatedUser);
        newComment.setText(comment.getText());

        Comment createdComment = commentRepository.save(newComment);
        return createdComment;
    }
}
