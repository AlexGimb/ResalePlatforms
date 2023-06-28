package ru.skypro.ResalePlatforms.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.dto.CommentsDTO;


@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class CommentController {



    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDTO> getComments(@PathVariable("id") int id) {
        // Заглушка для значения по умолчанию
        CommentsDTO response = new CommentsDTO();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentsDTO> addComment(@PathVariable("id") int id, @RequestBody CommentDTO commentDTO) {
        // Логика добавления комментария к объявлению с заданным id
        CommentsDTO response = new CommentsDTO();
        return ResponseEntity.ok(response);
    }
}
