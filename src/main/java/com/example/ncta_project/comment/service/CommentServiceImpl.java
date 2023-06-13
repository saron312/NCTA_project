package com.example.ncta_project.comment.service;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.comment.Comment;
import com.example.ncta_project.comment.dto.CommentDTO;
import com.example.ncta_project.comment.dto.CommentInsertDTO;
import com.example.ncta_project.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void insertComment(String memberId, CommentInsertDTO commentInsertDTO) {
        commentRepository.save(commentInsertDTO.toEntity(memberId));
    }

    @Override
    public List<CommentDTO> getCommentList(Long bId) {
        Pageable pageable = PageRequest.of(0, 20);
        return commentRepository.getCommentList(bId,pageable)
                .map(c -> CommentDTO.fromEntity(c,dateFormat(c))).toList();
    }

    public String dateFormat(Comment comment){
        if (comment.getModifiedAt().toLocalDate().isBefore(LocalDate.now())) {
            return comment.getModifiedAt().format(DateTimeFormatter.ofPattern("yy.MM.dd"));
        } else {
            return comment.getModifiedAt().format(DateTimeFormatter.ofPattern("HH:mm"));
        }
    }
}
