package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;
import ru.skypro.ResalePlatforms.service.CommentDetailsService;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads/{adId}/comments/{commentId}")
public class CommentDetailsController {

    private final CommentDetailsService commentDetailsService;

    public CommentDetailsController(CommentDetailsService commentDetailsService) {
        this.commentDetailsService = commentDetailsService;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@PathVariable("commentId") int commentId, @PathVariable String adId) {
        commentDetailsService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<CommentDTO> updateComment(@PathVariable("adId") int adId, @PathVariable("commentId") int commentId, @RequestBody CreateOrUpdateCommentDTO comment) {
        // Логика обновления комментария
        CommentDTO updatedComment = commentDetailsService.updateComment(adId, commentId, comment);
        return ResponseEntity.ok(updatedComment);
    }

}
