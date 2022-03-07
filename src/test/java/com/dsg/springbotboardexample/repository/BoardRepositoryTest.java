package com.dsg.springbotboardexample.repository;

import com.dsg.springbotboardexample.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @DisplayName("add 테스트")
    @Test
    public void addTest() {

        IntStream.rangeClosed(1,20).forEach(i -> {
            Board board = Board.builder()
                    .title("board_dsg" + i)
                    .content("board_dsg_content" + i)
                    .build();
            boardRepository.save(board);
        });

    }

}