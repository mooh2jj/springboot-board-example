package com.dsg.springbotboardexample.controller;

import com.dsg.springbotboardexample.entity.Board;
import com.dsg.springbotboardexample.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String writedo(Board board, Model model) {

        boardService.write(board);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

//        return board.toString();
        return "board/message";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.list());
        return "board/list";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") Long id) {
        model.addAttribute("board", boardService.view(id));
        return "board/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deleteById(id);

        return "redirect:/board/list";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id,
                         Model model) {
        model.addAttribute("board", boardService.view(id));

        return "board/modify";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Board board) {

        Board boardTemp = boardService.view(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }
}
