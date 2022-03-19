package com.dsg.springbootboardexample.controller.api;

import com.dsg.springbootboardexample.entity.CommentDto;
import com.dsg.springbootboardexample.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/boards/{boardId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable Long boardId,
            @RequestBody CommentDto commentDto) {

        return new ResponseEntity<>(commentService.createComment(boardId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/boards/{boardId}/comments")
    public List<CommentDto> getCommentsByBoardId(@PathVariable Long boardId) {
        return commentService.getCommentsByBoardId(boardId);
    }

    @GetMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId) {

        return ResponseEntity.ok(commentService.getCommentById(boardId, commentId));
    }

    @PutMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId,
            @RequestBody CommentDto commentDto
    ) {
        return ResponseEntity.ok(commentService.updateComment(boardId, commentId, commentDto));
    }

    @DeleteMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(boardId, commentId);
        return new ResponseEntity<>("comment deleteAll successfully.", HttpStatus.OK);
    }
}
