package com.dsg.springbootboardexample.repository;

import com.dsg.springbootboardexample.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
