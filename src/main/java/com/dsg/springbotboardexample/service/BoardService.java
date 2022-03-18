package com.dsg.springbotboardexample.service;

import com.dsg.springbotboardexample.entity.Board;
import com.dsg.springbotboardexample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board, MultipartFile file) throws IOException {

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/"+fileName);
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 특정 게시글 상세보기
    public Board view(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 id입니다."));
    }

    // 특정 게시글 삭제
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public Page<Board> searchList(String searchKeyword, Pageable pageable) {
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }
}
