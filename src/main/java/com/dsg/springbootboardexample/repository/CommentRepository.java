package com.dsg.springbootboardexample.repository;

import com.dsg.springbootboardexample.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
