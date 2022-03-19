package com.dsg.springbootboardexample.repository;

import com.dsg.springbootboardexample.entity.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

//    @BeforeEach
//    void beforeEach() {
//        boardRepository.deleteAll();
//    }

    // Long id도 초기화 했으면 좋겠는데...

    @DisplayName("add 테스트")
    @Test
    public void addTest() {

        IntStream.rangeClosed(1,140).forEach(i -> {
            Board board = Board.builder()
                    .title("board_dsg_title" + i)
                    .content("board_dsg_content" + i)
                    .writer("board_dsg" + i)
                    .build();
            boardRepository.save(board);
        });

    }

    @DisplayName("update 테스트")
    @Test
    public void updateTest() {

        Optional<Board> byId = boardRepository.findById(100L);

        if (byId.isPresent()) {
            Board board = byId.get();

            board.setTitle("Changed Title ...");
            board.setContent("Changed Content ...");

            boardRepository.save(board);
        }
    }

}