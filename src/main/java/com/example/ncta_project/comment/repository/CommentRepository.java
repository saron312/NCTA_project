package com.example.ncta_project.comment.repository;


import com.example.ncta_project.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

