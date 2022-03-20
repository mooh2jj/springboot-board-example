package com.dsg.springbootboardexample.service;

import com.dsg.springbootboardexample.entity.Board;
import com.dsg.springbootboardexample.entity.Comment;
import com.dsg.springbootboardexample.dto.CommentDto;
import com.dsg.springbootboardexample.exception.BlogAPIException;
import com.dsg.springbootboardexample.exception.ResourceNotFoundException;
import com.dsg.springbootboardexample.repository.BoardRepository;
import com.dsg.springbootboardexample.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    private final ModelMapper mapper;

    @Override
    public CommentDto createComment(Long boardId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board", "id", boardId));
        comment.setBoard(board);
        commentRepository.save(comment);

        return mapToDto(comment);
    }

    private CommentDto mapToDto(Comment comment) {
/*        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();*/
        return mapper.map(comment, CommentDto.class);
    }

    private Comment mapToEntity(CommentDto commentDto) {
/*            return Comment.builder()
                    .id(commentDto.getId())
                    .name(commentDto.getName())
                    .email(commentDto.getEmail())
                    .body(commentDto.getBody())
                    .build();*/
        return mapper.map(commentDto, Comment.class);
    }
    @Override
    public List<CommentDto> getCommentsByBoardId(Long boardId) {
        List<Comment> comments = commentRepository.findByBoardId(boardId);
        return comments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public CommentDto getCommentById(Long boardId, Long commentId) {
        Comment comment = errorCheckComment(boardRepository, boardId, commentRepository, commentId);

        return mapToDto(comment);
    }
    @Override
    public CommentDto updateComment(Long boardId, Long commentId, CommentDto commentRequest) {
        Comment comment = errorCheckComment(boardRepository, boardId, commentRepository, commentId);

        mapToUpdated(commentRequest, comment);

        Comment updatedComment = commentRepository.save(comment);

        return mapToDto(updatedComment);

    }

    private void mapToUpdated(CommentDto commentRequest, Comment comment) {
        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());
    }
    @Override
    public void deleteComment(Long boardId, Long commentId) {
        Comment comment = errorCheckComment(boardRepository, boardId, commentRepository, commentId);

        commentRepository.delete(comment);
    }

    private Comment errorCheckComment(BoardRepository boardRepository, Long boardId, CommentRepository commentRepository, Long commentId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board", "id", boardId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getBoard().getId().equals(board.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment가 board에 속하지 않습니다!");
        }
        return comment;
    }
}
