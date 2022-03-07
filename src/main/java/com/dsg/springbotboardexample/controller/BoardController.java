package com.dsg.springbotboardexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello!";
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }
}
