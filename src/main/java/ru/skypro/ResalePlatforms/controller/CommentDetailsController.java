package ru.skypro.ResalePlatforms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads/{adId}/comments/{commentId}")
public class CommentDetailsController {

    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@PathVariable("adId") int adId, @PathVariable("commentId") int commentId) {
        // Логика удаления комментария
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<CommentDTO> updateComment(@PathVariable("adId") int adId, @PathVariable("commentId") int commentId, @RequestBody CreateOrUpdateCommentDTO comment) {
        // Логика обновления комментария
        CommentDTO updatedComment = new CommentDTO();
        return ResponseEntity.ok(updatedComment);
    }

}
