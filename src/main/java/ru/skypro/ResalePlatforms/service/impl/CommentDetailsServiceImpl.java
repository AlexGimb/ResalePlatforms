package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;
import ru.skypro.ResalePlatforms.entity.Comment;
import ru.skypro.ResalePlatforms.repository.CommentRepository;
import ru.skypro.ResalePlatforms.service.CommentDetailsService;
import ru.skypro.ResalePlatforms.service.UserService;

@Service
public class CommentDetailsServiceImpl implements CommentDetailsService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentDetailsServiceImpl(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;

    }
    /**
     * Удаляет комментарий по его идентификатору.
     *
     * @param commentId идентификатор комментария
     * @throws ResponseStatusException если комментарий не найден
     */
    @Override
    public void deleteComment(int commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }
        commentRepository.deleteById(commentId);
    }

    /**
     * Обновляет комментарий.
     *
     * @param adId      идентификатор объявления
     * @param commentId идентификатор комментария
     * @param comment   объект CreateOrUpdateComment с обновленными данными комментария
     * @return объект Comment с обновленной информацией о комментарии
     * @throws ResponseStatusException если комментарий не найден
     */
    @Override
    public CommentDTO updateComment(int adId, int commentId, CreateOrUpdateCommentDTO comment) {
        Comment existingComment = commentRepository.findById(commentId)
                .filter(c -> c.getAdId() == adId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Comment not found"));


        existingComment.setText(comment.getText());

        Comment updatedComment = commentRepository.save(existingComment);
        return updatedComment;
    }
}
