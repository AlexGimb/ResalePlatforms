package ru.skypro.ResalePlatforms.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CommentsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateCommentDTO;
import ru.skypro.ResalePlatforms.service.CommentService;


@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDTO> getComments(@PathVariable("id") int id) {
        CommentsDTO comments = commentService.getCommentsByAd(id);
        return ResponseEntity.ok(comments);
    }
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable("id") int adId,
                                                 @RequestBody CreateOrUpdateCommentDTO createOrUpdateComment) {
        CommentDTO comment = commentService.addComment(adId, createOrUpdateComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
