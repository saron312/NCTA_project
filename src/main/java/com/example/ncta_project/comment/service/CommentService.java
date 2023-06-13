package com.example.ncta_project.comment.service;

import com.example.ncta_project.comment.dto.CommentDTO;
import com.example.ncta_project.comment.dto.CommentInsertDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    void insertComment(String memberId, CommentInsertDTO commentInsertDTO);
    List<CommentDTO> getCommentList(Long bId);
}
