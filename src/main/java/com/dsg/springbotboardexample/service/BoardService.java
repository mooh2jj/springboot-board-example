package com.dsg.springbotboardexample.service;

import com.dsg.springbotboardexample.entity.Board;
import com.dsg.springbotboardexample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list() {
        return boardRepository.findAll();
    }
}
