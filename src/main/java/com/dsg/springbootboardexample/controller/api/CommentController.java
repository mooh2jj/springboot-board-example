package com.dsg.springbootboardexample.controller.api;

import com.dsg.springbootboardexample.dto.CommentDto;
import com.dsg.springbootboardexample.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(value = "comment controller exposes crud rest-apis")
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "create comment rest api")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/boards/{boardId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable Long boardId,
            @Valid @RequestBody CommentDto commentDto) {

        return new ResponseEntity<>(commentService.createComment(boardId, commentDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "getAll comments rest api")
    @GetMapping("/boards/{boardId}/comments")
    public List<CommentDto> getCommentsByBoardId(@PathVariable Long boardId) {
        return commentService.getCommentsByBoardId(boardId);
    }

    @ApiOperation(value = "getById comment rest api")
    @GetMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId) {

        return ResponseEntity.ok(commentService.getCommentById(boardId, commentId));
    }

    @ApiOperation(value = "update comment rest api")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId,
            @Valid @RequestBody CommentDto commentDto
    ) {
        return ResponseEntity.ok(commentService.updateComment(boardId, commentId, commentDto));
    }

    @ApiOperation(value = "delete comment rest api")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/boards/{boardId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long boardId,
            @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(boardId, commentId);
        return new ResponseEntity<>("comment deleteAll successfully.", HttpStatus.OK);
    }
}
