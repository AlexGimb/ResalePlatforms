package ru.skypro.ResalePlatforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.ResalePlatforms.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
