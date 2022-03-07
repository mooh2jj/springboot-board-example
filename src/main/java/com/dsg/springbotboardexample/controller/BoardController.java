package com.dsg.springbotboardexample.controller;

import com.dsg.springbotboardexample.entity.Board;
import com.dsg.springbotboardexample.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello!";
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

/*    @PostMapping("/writedo")
    @ResponseBody
    public String writedo(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        log.info("title: {}", title);
        log.info("content: {}", content);

        Board board = new Board();

        board.setTitle(title);
        board.setContent(content);

        return board.toString();
    }*/

    @PostMapping("/writedo")
    @ResponseBody
    public String writedo(Board board) {

        boardService.write(board);

        return board.toString();
    }
}
