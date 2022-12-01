package com.example.ncta_project.board.dto;

import com.example.ncta_project.board.Board;
import com.example.ncta_project.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class InsertDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String subject;

    public Board toEntity(String memberId) {
        Board board = Board.builder()
                .title(title)
                .subject(subject)
                .content(content)
                .member(Member.builder().memberId(memberId).build())
                .build();
        return board;
    }
}
