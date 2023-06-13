package com.example.ncta_project.comment.dto;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.comment.Comment;
import com.example.ncta_project.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CommentInsertDTO {
    @NotBlank
    private String comment;
    @NotBlank
    private Long bId;

    public Comment toEntity(String memberId) {
        return Comment.builder()
                .comment(comment)
                .board(Board.builder().bId(bId).build())
                .secret(false)
                .member(Member.builder().memberId(memberId).build())
                .build();
    }
}