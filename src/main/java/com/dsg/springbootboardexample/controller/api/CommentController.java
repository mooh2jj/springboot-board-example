package com.dsg.springbootboardexample.controller.api;

import com.dsg.springbootboardexample.entity.CommentDto;
import com.dsg.springbootboardexample.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
