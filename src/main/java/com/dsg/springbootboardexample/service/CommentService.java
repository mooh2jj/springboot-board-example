package com.dsg.springbootboardexample.service;

import com.dsg.springbootboardexample.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(Long boardId, CommentDto commentDto);

    List<CommentDto> getCommentsByBoardId(Long boardId);

    CommentDto getCommentById(Long boardId, Long commentId);

    CommentDto updateComment(Long boardId, Long commentId, CommentDto commentRequest);

    void deleteComment(Long boardId, Long commentId);

}
