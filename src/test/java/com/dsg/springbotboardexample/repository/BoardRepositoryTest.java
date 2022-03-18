package com.dsg.springbotboardexample.repository;

import com.dsg.springbotboardexample.entity.Board;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void beforeEach() {
        boardRepository.deleteAll();
    }

    // Long id도 초기화 했으면 좋겠는데...

    @DisplayName("add 테스트")
    @Test
    public void addTest() {

        IntStream.rangeClosed(1,140).forEach(i -> {
            Board board = Board.builder()
                    .title("board_dsg_title" + i)
                    .content("board_dsg_content" + i)
                    .build();
            boardRepository.save(board);
        });

    }

}