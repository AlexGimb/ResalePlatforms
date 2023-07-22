package ru.skypro.ResalePlatforms.component;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.ResalePlatforms.dto.CommentDTO;
import ru.skypro.ResalePlatforms.entity.Comment;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO toDto(Comment comment);

    Comment toEntity(CommentDTO commentDTO);
}
