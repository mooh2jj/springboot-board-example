package com.dsg.springbootboardexample.service;

import com.dsg.springbootboardexample.entity.Board;
import com.dsg.springbootboardexample.entity.Comment;
import com.dsg.springbootboardexample.entity.CommentDto;
import com.dsg.springbootboardexample.repository.BoardRepository;
import com.dsg.springbootboardexample.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public CommentDto createComment(Long boardId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("board를 찾을 수 없습니다."));
        comment.setBoard(board);
        commentRepository.save(comment);

        return mapToDto(comment);
    }

    private CommentDto mapToDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    private Comment mapToEntity(CommentDto commentDto) {
            return Comment.builder()
                    .id(commentDto.getId())
                    .name(commentDto.getName())
                    .email(commentDto.getEmail())
                    .body(commentDto.getBody())
                    .build();
    }
}
