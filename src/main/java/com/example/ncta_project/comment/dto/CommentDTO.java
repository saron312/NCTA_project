package com.example.ncta_project.comment.dto;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.board.dto.BoardDTO;
import com.example.ncta_project.comment.Comment;
import com.example.ncta_project.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
public class CommentDTO {

    private String comment;
    private String modifiedAt;
//    private Long bId;
    private String writer;

    public static CommentDTO fromEntity(Comment comment, String modifiedAt) {
        return CommentDTO.builder()
                .comment(comment.getComment())
                .modifiedAt(modifiedAt)
//                .bId(comment.getBoard().getBId())
                .writer(comment.getMember().getMemberId())
                .build();
    }
}
