package com.example.ncta_project.comment.repository;


import com.example.ncta_project.comment.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.board.bId=:bId")
    Page<Comment> getCommentList(Long bId, Pageable pageable);
}

